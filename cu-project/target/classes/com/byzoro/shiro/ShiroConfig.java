package com.byzoro.shiro;

import com.byzoro.entity.SYSResource;
import com.byzoro.service.SYSResourceService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ShiroConfig
 * Description:
 * CreateDate: 2018/7/11 21:35
 * Author: liwenhui
 * UpdateUser:
 * UpdateDate:
 * UpdateRemark:
 * Version: 1.0
 **/
@Configuration
public class ShiroConfig {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Resource
	private SYSResourceService resourceService;

	/**
	 * shiro过滤器
	 *
	 * @param securityManager 安全管理器
	 *                        它管理着所有Subject、且负责进行认证和授权、及会话、缓存的管理
	 *                        所有与安全有关的操作都会与SecurityManager交互
	 *                        管理着所有Subject
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shifoFilter(SecurityManager securityManager) {
		log.info("加载shiro过滤器");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//没有登录的用户请求需要登录的页面时自动跳转到登录页面，不是必须的属性，不输入地址的话会自动寻找项目web项目的根目录下的”/login.jsp”页面。
		shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
		//登录成功默认跳转页面，不配置则跳转至”/”。如果登陆前点击的一个需要登录的页面，则在登录自动跳转到那个需要登录的页面。不跳转到此。
		//没有权限默认跳转的页面,
		shiroFilterFactoryBean.setUnauthorizedUrl("/index");
		//---------------------------------------配置权限拦截器--------------------------------------------------s
		//配置访问权限
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

		List<SYSResource> resources = resourceService.getAllResource();

		for (SYSResource resource : resources) {
			filterChainDefinitionMap.put(resource.getResourceHref(), "perms["+resource.getResourceHref()+"]");
		}

		//验证码
		filterChainDefinitionMap.put("/defaultKaptcha", "anon");
		//开放登录接口
		filterChainDefinitionMap.put("/user/login", "anon");
		filterChainDefinitionMap.put("/test/test1", "anon");
		filterChainDefinitionMap.put("/user/toLogin", "anon");
		filterChainDefinitionMap.put("/user/noLogin", "anon");
//		filterChainDefinitionMap.put("/user/logout", "logout");
		filterChainDefinitionMap.put("/code.jpg", "anon");
		//开放大屏数据可视化请求接口
		filterChainDefinitionMap.put("/api/screen/**", "anon");
		//开放静态资源,
		filterChainDefinitionMap.put("/favicon.ico", "anon");//网站图标
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/plugins/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		//拦截所有访问接口
		//filterChainDefinitionMap.put("/**", "authc");
		// 配置需要拦截的链接
		filterChainDefinitionMap.put("/**", "ShiroAuthFilter");
		Map<String, Filter> filterMap = new LinkedHashMap<>();
		// 自定义的登录过滤器
		filterMap.put("ShiroAuthFilter", new ShiroAuthFilter());
		shiroFilterFactoryBean.setFilters(filterMap);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterFactoryBean;
	}

	@Bean
	public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm, SessionManager defaultWebSessionManager) {
		log.info("--->>加载SecurityManager");
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		//设置realm
		defaultWebSecurityManager.setRealm(authRealm);
		defaultWebSecurityManager.setSessionManager(defaultWebSessionManager);
		//TODO 缓存功能
		return defaultWebSecurityManager;
	}

	@Bean
	public SessionManager defaultWebSessionManager() {
		DefaultWebSessionManager defaultWebSessionManager=new DefaultWebSessionManager();
		ArrayList<SessionListener> sessionListeners = new ArrayList<>();
		defaultWebSessionManager.setSessionListeners(sessionListeners);
		//设置是否重写URL包含sessionId
		defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
		//session的失效时长，单位:ms 默认30分钟1800000
		defaultWebSessionManager.setGlobalSessionTimeout(1800000 );
		//删除失效的session
		defaultWebSessionManager.setDeleteInvalidSessions(true);
		return defaultWebSessionManager;
	}


	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 * @return
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

}
