package com.byzoro.shiro;

import com.byzoro.entity.SYSResource;
import com.byzoro.entity.SYSRole;
import com.byzoro.entity.SYSUser;
import com.byzoro.entity.SessionInfo;
import com.byzoro.service.SYSResourceService;
import com.byzoro.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@Component("authRealm")
public class AuthRealm extends AuthorizingRealm{

	@Resource
	private SysUserService userService;

	@Resource
	private SYSResourceService resourceService;

	private static final Logger logger = LoggerFactory.getLogger(AuthorizingRealm.class);

	/**
	 * 初始化密码校验的算法和迭代次数
	 */
	@PostConstruct
	private void initCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName(Sha1Hash.ALGORITHM_NAME);
		hashedCredentialsMatcher.setHashIterations(1024);
		setCredentialsMatcher(hashedCredentialsMatcher);
		logger.info("--->>密码校验器配置完成");
	}



	/**
	 * 处理角色的权限信息,权限验证处理方法
	 * @param principalCollection
	 * @return
	 */
	@SuppressWarnings("AlibabaRemoveCommentedCode")
    @Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.debug("##########开始权限认证##########");
		//获取登录时输入的用户名
		SessionInfo sessionInfo = (SessionInfo) super.getAvailablePrincipal(principalCollection);
		String loginName = sessionInfo.getUname();

		logger.debug("输入的用户名："+loginName);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("uname", loginName);
		//到数据库查是否有此对象
		SYSUser user=userService.getSYSUser(param);

		if(user!=null){
			//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			//用户的角色集合
			Collection<String> permissionNames = new ArrayList<String>();
			List<SYSRole> userRoleList = userService.getRolesByUname(user.getUname());
			for(SYSRole role : userRoleList){
				if(role !=null){
					Long roleId = (Long)role.getRoleId();
					List<SYSResource> list = resourceService.getResourceByRoleId(roleId);
					for(SYSResource rMap : list){
						permissionNames.add(rMap.getResourceHref());
					}
				}
			}
			List<SYSResource> uList = userService.getUserResListByUname(user.getUname());
			for(SYSResource uMap : uList){
				permissionNames.add(uMap.getResourceHref());
			}
			//用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
			/*List<SYSPermission> permissionList=userService.getPermissionList(user);
			Collection<String> permissionNames = new ArrayList<String>();
			for (SYSPermission permission : permissionList) {
				permissionNames.add(permission.getPermissionName());
			}*/
			info.addStringPermissions(permissionNames);
			logger.debug("权限列表："+permissionNames);
			return info;
		}
		logger.debug("未登录！");
		return null;

//		LOG.info("登录授权");
//		ShiroUser shiroUser = (ShiroUser)principalCollection.getPrimaryPrincipal();
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		List<SystemRole> systemRoles = systemRoleService.queryByUserId(shiroUser.getId());
//		for (SystemRole systemRole : systemRoles) {
//			info.addRole(systemRole.getRoleCode());
//			info.addStringPermissions(systemRole.getPermisstions());
//		}
//		return info;
	}

	/**
	 * 处理用户的角色信息,登录认证处理方法
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//UsernamePasswordToken对象用来存放提交的登录信息
		UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("uname", token.getUsername());
		//查出是否有此用户
		SYSUser user=userService.getSYSUser(param);

		if(user!=null){
			logger.debug("登陆认证成功！");
			return new SimpleAuthenticationInfo(new SessionInfo(user), user.getPwd().substring(16),
					ByteSource.Util.bytes(user.getPwd().substring(0, 16)), user.getUname());
		}
		logger.debug("登陆认证失败，请登录");
		return null;
	}
}
