package com.ness.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ness.interceptors.SecurityInterceptor;

@Configuration
public class WebAdaptor extends WebMvcConfigurerAdapter{
	@Autowired
	SecurityInterceptor securityInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(securityInterceptor).addPathPatterns("/viewOrders.htm");
	}

}
