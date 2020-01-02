package com.byzoro.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

/**
 * ClassName: ShiroPermissionFactory
 * Description:
 * CreateDate: 2018/8/7 22:48
 * Author: liwenhui
 * UpdateUser:
 * UpdateDate:
 * UpdateRemark:
 * Version: 1.0
 **/
public class ShiroPermissionFactory extends ShiroFilterFactoryBean {

	/** 记录配置中的过滤链 */
	public static String filterChainDefinitions = "";//这个要和配置文件中的名称要一样

	@Override
	public void setFilterChainDefinitions(String definitions) {
		filterChainDefinitions = definitions;// 记录配置的静态过滤链


	}

}
