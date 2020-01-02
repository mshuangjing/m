package com.byzoro.controller;

import com.byzoro.entity.SYSResource;
import com.byzoro.entity.SYSRole;
import com.byzoro.entity.SYSUser;
import com.byzoro.entity.SessionInfo;
import com.byzoro.service.SYSLogService;
import com.byzoro.service.SYSResourceService;
import com.byzoro.service.SysUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.byzoro.utils.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    static final Pattern UNAMEFLAG = Pattern.compile("^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$");
    static final Pattern PHONEFLAG = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    static final Pattern EMAILFLAG = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    static final Pattern PWDFLAG = Pattern.compile("^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])).{8,20}$");
    @Autowired
    private SysUserService userService;

    @Autowired
    private SYSResourceService resourceService;

    @Autowired
    private SYSLogService sysLogService;
    //声明objectMapper作为公共json转换
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/menu/configurationManagement")
    public String configurationManagement(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("list");
        List<SYSResource> resourceList = new ArrayList<SYSResource>();
        Subject subject = SecurityUtils.getSubject();
        SessionInfo info = (SessionInfo) subject.getPrincipal();
        List<SYSRole> userRoleList = userService.getRolesByUname(info.getUname());
        for (SYSRole role : userRoleList) {
            if (role != null) {
                Long roleId = (Long) role.getRoleId();
                List<SYSResource> list = resourceService.getResourceByRoleId(roleId);
                for (SYSResource rMap : list) {
                    if (!resourceList.contains(rMap)) {
                        resourceList.add(rMap);
                    }
                }
            }
        }
        List<SYSResource> uList = userService.getUserResListByUname(info.getUname());
        for (SYSResource uMap : uList) {
            if (!resourceList.contains(uMap)) {
                resourceList.add(uMap);
            }
        }

        List<SYSResource> dealList = resourceService.dealAllResource(resourceList);
        String resourceHref = "/customer/user/list";
        System.out.println(dealList.get(0));
        if (dealList.get(0) != null) {
            session.setAttribute("list", dealList.get(0).getChildList());
            resourceHref = dealList.get(0).getChildList().get(0).getChildList().get(0).getResourceHref();
        }
        logger.info("登陆成功，加载主页面数据");
        return "redirect:" + resourceHref;
    }

    /**
     * 用户管理 账号删除功能
     * @param request
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteUser(HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();
        if ("1".equals(request.getParameter("user_id")) || "admin".equals(request.getParameter("uname")) || "0".equals(request.getParameter("type"))) {
            result.put("success", false);
            result.put("message", "管理员账号不可删除！");
            return result;
        } else {
            String userId = request.getParameter("user_id");
            int deleteUserInt = userService.deleteUser(userId);
            if (deleteUserInt == 1) {
                result.put("success", true);
                result.put("message", "删除成功！");
            } else {
                result.put("success", false);
                result.put("message", "删除失败！");
            }
            SYSUser sysUser = userService.selectByPrimaryKey(Long.parseLong(userId));
//            ObjectMapper mapper = new ObjectMapper();
            String dels="";
            try {
                dels = mapper.writeValueAsString(sysUser);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }finally {
                sysLogService.insertSyslog("用户管理删除账号",dels,"", SysLogCodeConstant.DELETE,sysUser.getUname());
                return result;
            }
        }
    }

    @RequestMapping("noPassCheck")
    @ResponseBody
    public Map<String, Object> noPassCheck(HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();
        String userId = request.getParameter("user_id");
        String status = request.getParameter("status");

        Map<String, Object> params = new HashMap<String, Object>();
        if ("2".equals(status)) {
            result.put("success", true);
            result.put("message", "该用户已审核通过！");
            return result;
        }
        if ("3".equals(status)) {
            result.put("success", true);
            result.put("message", "该用户已审核不通过！");
            return result;
        }
        if ("4".equals(status)) {
            result.put("success", true);
            result.put("message", "该用户已注销！");
            return result;
        }

        params.put("status", "3");
        params.put("userId", Integer.parseInt(userId));
        userService.checkUser(params);

        result.put("success", true);
        result.put("message", "审核不通过！");
        return result;
    }

    //修改用户
    /*@RequestMapping("modifyUser")
    @ResponseBody
    public Map<String, Object> modifyUser(HttpServletRequest request) throws JsonProcessingException {

        Map<String, Object> result = new HashMap<String, Object>();
        String uname = RegExUtil.getTextFromHtml(request.getParameter("uname"));
        String pwd = RegExUtil.getTextFromHtml(request.getParameter("pwd"));
        String pwd1 = request.getParameter("pwd");
        String phone = RegExUtil.getTextFromHtml(request.getParameter("phone"));
        String email = RegExUtil.getTextFromHtml(request.getParameter("email"));
        String userId = request.getParameter("user_id");

        boolean unameFlag = UNAMEFLAG.matcher(uname).matches();
        boolean phoneFlag = PHONEFLAG.matcher(phone).matches();
        boolean emailFlag = EMAILFLAG.matcher(email).matches();

        if (!unameFlag) {
            result.put("success", true);
            result.put("message", "修改失败！！！用户名格式：限16个字符，支持中英文、数字、减号或下划线");
            return result;
        }
        if (phone != null && !"".equalsIgnoreCase(phone) && !phoneFlag) {
            result.put("success", true);
            result.put("message", "修改失败！！！手机号码格式不正确！");
            return result;
        }

        if (email != null && !"".equalsIgnoreCase(email) && !emailFlag) {
            result.put("success", true);
            result.put("message", "修改失败！！！邮箱格式不正确！");
            return result;
        }
        SYSUser user = userService.getUserByPrimaryKey((long) Integer.parseInt(userId));
//        ObjectMapper mapper = new ObjectMapper();
        String beforeUpd = mapper.writeValueAsString(user);
        user.setUname(uname);
        user.setPwd(pwd);
        user.setPhone(phone);
        user.setEmail(email);
        userService.updateByPrimaryKeySelective(user);

        result.put("success", true);
        result.put("message", "修改用户成功！");
        //操作日志
        String afterUpd = mapper.writeValueAsString(user);
        sysLogService.insertSyslog("用户管理修改用户",beforeUpd,afterUpd,"3",afterUpd);
        return result;
    }*/


    //添加用户
    @RequestMapping("addUser")
    @ResponseBody
    public Map<String, Object> addUser(HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String uname = RegExUtil.getTextFromHtml(request.getParameter("uname"));
            String pwd = RegExUtil.getTextFromHtml(request.getParameter("pwd"));
            String pwd1 = request.getParameter("pwd");
            String pwdCopy = RegExUtil.getTextFromHtml(request.getParameter("pwdCopy"));
            String phone = RegExUtil.getTextFromHtml(request.getParameter("phone"));
            String email = RegExUtil.getTextFromHtml(request.getParameter("email"));
            boolean unameFlag = UNAMEFLAG.matcher(uname).matches();
            boolean pwdFlag = PWDFLAG.matcher(pwd).matches();
            //查找密码中是否有空格
            int blankFlag = pwd1.indexOf(" ");
            boolean phoneFlag = PHONEFLAG.matcher(phone).matches();
            boolean emailFlag = EMAILFLAG.matcher(email).matches();

            if (!unameFlag) {
                result.put("success", true);
                result.put("message", "添加失败！！！用户名格式：限16个字符，支持中英文、数字、减号或下划线");
                return result;
            }
            //如果没有空格，blankFlag 返回-1
            if (blankFlag != -1) {
                result.put("success", true);
                result.put("message", "添加失败！！！密码不能包含空格！");
                return result;
            }
            if (!pwdCopy.equals(pwd)) {
                result.put("success", true);
                result.put("message", "添加失败！！！两次输入的密码不一致！");
                return result;
            }
            if (!pwdFlag) {
                result.put("success", true);
                result.put("message", "添加失败！！！密码格式：8-20 位，必须包含大小写字母、数字、特殊字符（空格除外）");
                return result;
            }

            if (phone != null && !"".equalsIgnoreCase(phone) && !phoneFlag) {
                result.put("success", true);
                result.put("message", "添加失败！！！手机号码格式不正确！");
                return result;
            }

            if (email != null && !"".equalsIgnoreCase(email) && !emailFlag) {
                result.put("success", true);
                result.put("message", "添加失败！！！邮箱格式不正确！");
                return result;
            }


            boolean checkNameFlag = userService.checkName(uname);
            if (!checkNameFlag) {
                result.put("success", true);
                result.put("message", "添加失败！！！用户已存在");
                return result;
            }

            SYSUser user = new SYSUser();
            user.setUname(uname);
            user.setPwd(encryptPassword(pwd));
            user.setPhone(phone);
            user.setEmail(email);
            user.setStatus("2");
            user.setType("1");

            userService.insertUser(user);

            result.put("success", true);
            result.put("message", "添加用户成功！");
            String adds = mapper.writeValueAsString(user);
            sysLogService.insertSyslog("用户管理新增","",adds,"2",user.getUname());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "添加用户失败！");
        }
        return result;
    }

    @RequestMapping("goUserList")
    public String goUserList(HttpServletRequest request) {
        return "admin/userList";
    }

    //查询用户列表
    /*@RequestMapping("userList")
    @ResponseBody
    public Map<String, Object> userList(HttpServletRequest request) {
        String r = request.getParameter("rows");
        String p = request.getParameter("page");
        String uname = request.getParameter("uname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String type = request.getParameter("type");

        Map<String, Object> result = new HashMap<String, Object>();
        HashMap<String, Object> param = new HashMap<String, Object>();

        if ("".equals(uname) || uname == null) {
            param.put("uname", "");
        } else {
            param.put("uname", "%" + uname + "%");
        }
        if ("".equals(phone) || phone == null) {
            param.put("phone", "");
        } else {
            param.put("phone", "%" + phone + "%");
        }
        if ("".equals(email) || email == null) {
            param.put("email", "");
        } else {
            param.put("email", "%" + email + "%");
        }
        param.put("status", status);
        param.put("type", type);
        int count = userService.getCount(param);
        PageUtil page = new PageUtil(Integer.parseInt(r), userService.getCount(param), Integer.parseInt(p));
        param.put("page", page.getFromIndex());
        param.put("row", page.getPageSize());
        List<Map<String, Object>> newList = userService.getSYSUserList(param);
        result.put("total", count);
        result.put("rows", newList);
        return result;

    }*/

    /*//修改密码
    @RequestMapping("modifyPWD")
    @ResponseBody
    public Map<String, Object> modifyPWD(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        String newPWD = RegExUtil.getTextFromHtml(request.getParameter("newPWD"));
        String confirmPwd = RegExUtil.getTextFromHtml(request.getParameter("confirmPwd"));
        String pwd1 = request.getParameter("newPWD");
        String oldPWD = RegExUtil.getTextFromHtml(request.getParameter("oldPWD"));
        String pwd2 = request.getParameter("oldPWD");
        boolean pwdFlag = PWDFLAG.matcher(newPWD).matches();
        int blankFlag = pwd1.indexOf(" ");

        Long userId = Long.parseLong(request.getParameter("userId"));
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        SYSUser user = userService.getSYSUser(param);
        sysLogService.insertSyslog("用户管理修改密码","","","3","");
        if (!user.getPwd().equals(oldPWD)) {
            result.put("success", false);
            result.put("message", "请输入正确的旧密码！");
            return result;
        }
        if (pwd2.equals(pwd1)) {
            result.put("success", true);
            result.put("message", "修改失败！！！新密码不能和旧密码相同！");
            return result;
        }
        if (blankFlag != -1) {
            result.put("success", true);
            result.put("message", "添加失败！！！密码不能包含空格！");
            return result;
        }
        if (!newPWD.equalsIgnoreCase(confirmPwd)) {
            result.put("success", true);
            result.put("message", "修改失败！！！两次新密码不一致！");
            return result;
        }
        if (!pwdFlag) {
            result.put("success", true);
            result.put("message", "修改失败！！！密码格式：8-20 位，必须包含大小写字母、数字、特殊字符（空格除外）");
            return result;
        }
        user.setPwd(encryptPassword(newPWD));
        if (userService.updateByPrimaryKeySelective(user) < 0) {
            result.put("success", false);
            result.put("message", "修改密码失败！");
            return result;
        }
        result.put("success", true);
        result.put("message", "修改密码成功！");
        return result;
    }*/

    /**
     * 用户登录接口
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpSession session) {
        Map<String, Object> result = new HashMap<String, Object>();

        //获取系统验证码
        String sysCode = (String) session.getAttribute("sysCode");

        logger.info("验证码为：" + sysCode);
        //获取用户输入的验证码
        String userCode = request.getParameter("userCode");
        //比对验证码
        if (userCode == null || !userCode.equalsIgnoreCase(sysCode)) {
            result.put("message", "验证码错误!");
            result.put("success", false);
            return result;
        }

        Map<String, Object> params = new HashMap<String, Object>();

        String name = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        params.put("uname", name);
        SYSUser user1 = userService.getSYSUser(params);
        //验证IP白名单
        //如果是admin用户不验证IP白名单
/*        if (!"admin".equals(name)) {
            //IP白名单开启则验证
            if (1 == userService.queryWhileStateByUname("admin")) {
                if (whiteIpService.checkIPAddr(getIpAddr(request))) {
                    result.put("message", "当前IP被限制，不能登录，请联系管理员！");
                    result.put("success", false);
                    logger.error("登录失败错误信息:当前IP被限制，不能登录，请联系管理员！" );
                    return result;
                }
            }
        }*/

        String[] autoLogin = request.getParameterValues("autoLogin");
        logger.debug("请求参数：name:" + name + "||pwd:" + pwd);
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);

        if (!StringUtils.isEmpty(autoLogin) && "1".equals(autoLogin[0])) {
            token.setRememberMe(true);
        }
        try {
            user.login(token);
            result.put("loginName",name);
            session.setAttribute("loginName", name);
            result.put("message", "登陆成功");
            result.put("success", true);
            //记录用户最后登录时间
            userService.updateLastloginTimeByUserId(user1.getUserId(), String.valueOf(TimestampUtils.currentTimestamp()));
        } catch (AuthenticationException e) {
            result.put("message", "用户名或密码错误!");
            result.put("success", false);
            logger.error("登录失败错误信息:" + e);
            token.clear();
        }
        sysLogService.insertSyslog("用户登录","","","5","");
        return result;
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public ViewResult logout(HttpServletRequest request, HttpServletResponse response) {
        ViewResult viewResult = new ViewResult();
        try {
            if (request.getHeader("X-Requested-With") != null
                    && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString())) {
                response.setStatus(401);
            }
            //登出操作日志增加
            sysLogService.insertSyslog("用户退出","","","6","");
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            logger.info("用户退出。。");
        } catch (Exception e) {
            e.printStackTrace();
            viewResult.setStatus(ViewResult.ERROR);
            viewResult.setInfo("操作失败");
            viewResult.setError(e.getMessage());
        }

        return viewResult;
    }

    /**
     * 跳转到登录页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(HttpServletRequest request, HttpServletResponse response) {
        logger.info("用户进入登录页面。。");
        return "index/login";
    }

    /**
     * 登陆成功
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginSuccess")
    public String loginSuccess(Model model, HttpServletRequest request, HttpSession session) {
        //获取权限开始
        List<SYSResource> resourceList = new ArrayList<SYSResource>();
        Subject subject = SecurityUtils.getSubject();
        SessionInfo info = (SessionInfo) subject.getPrincipal();
        List<SYSRole> userRoleList = userService.getRolesByUname(info.getUname());
        for (SYSRole role : userRoleList) {
            if (role != null) {
                Long roleId = (Long) role.getRoleId();
                List<SYSResource> list = resourceService.getResourceByRoleId(roleId);
                for (SYSResource rMap : list) {
                    if (!resourceList.contains(rMap)) {
                        resourceList.add(rMap);
                    }
                }
            }
        }
        List<SYSResource> uList = userService.getUserResListByUname(info.getUname());
        for (SYSResource uMap : uList) {
            if (!resourceList.contains(uMap)) {
                resourceList.add(uMap);
            }
        }
        //获取权限结束
        //获取登陆用户信息
        SYSUser sysUser = userService.selectByPrimaryKey(info.getUserId());
        //将参数传到页面
        request.setAttribute("sysUser",sysUser);
        return "index/index";
    }

    @RequestMapping(value = "grantUserResource")
    public String grantUserRole(HttpServletRequest request) {
        return "menu/role/grantResource";
    }

    @ResponseBody
    @RequestMapping(value = "insertRelationOfUserAndResource")
    public Map<String, Object> insertRelationOfUserAndResource(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        String userId = request.getParameter("userId");
        String ids = request.getParameter("ids");
        if (null == ids) {
            userService.deleteResourceByUserId(userId);
        } else {
            //刪除所有的
            userService.deleteResourceByUserId(userId);
            userService.insertRelationOfUserAndResource(userId, ids);
        }
        //如果前台传递过来的ids为null,那么删除角色的所有资源，不再做添加操作
        result.put("success", true);
        result.put("msg", "分配资源成功");
        return result;
    }

    /**
     * 加密密码
     *
     * @param plainPassword 原始密码
     * @return salt+ecryptedPwd
     */
    public static String encryptPassword(String plainPassword) {
        String salt = Hex.encodeHexString(DigestUtils.generateByteSalt(8));
        ByteSource saltBytes = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(Sha1Hash.ALGORITHM_NAME, plainPassword, saltBytes, 1024);
        String encryptedPwd = salt.concat(simpleHash.toString());
        return encryptedPwd;
    }

    // 获取ip地址
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        return ip;
    }
}
