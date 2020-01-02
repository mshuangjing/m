package com.byzoro.shiro;

import com.byzoro.utils.ViewResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @className: ShiroAuthFilter
 * @description:
 * @createDate: 2019/6/12 11:00
 * @author: liwenhui
 * @updateUser:
 * @updateDate:
 * @updateRemark:
 * @version: 1.0
 **/
public class ShiroAuthFilter extends FormAuthenticationFilter {


    public ShiroAuthFilter() {
        super();
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //Always return true if the request's method is OPTIONS
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res = (HttpServletResponse)response;
        res.setContentType("application/json; charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = res.getWriter();
        ViewResult viewResult = new ViewResult();
        viewResult.setStatus(ViewResult.NO_LOGIN);
        viewResult.setInfo("请重新登录");
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(viewResult);
        writer.write(responseJson);
        writer.close();
        //return false 拦截， true 放行
        return false;
    }
}
