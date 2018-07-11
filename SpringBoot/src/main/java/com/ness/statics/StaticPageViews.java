package com.ness.statics;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

@Configuration
public class StaticPageViews {
	@Bean(name = "indexViewController")
	public ParameterizableViewController indexPageViewController() {
		ParameterizableViewController pvc = new ParameterizableViewController();
		pvc.setViewName("Index");
		return pvc;
	}

	@Bean
	public HandlerMapping indexPageViewHandler() {
		SimpleUrlHandlerMapping surlhm = new SimpleUrlHandlerMapping();
		Map<String, Object> map = new HashMap<>();
		map.put("/index.htm","indexViewController");
		surlhm.setUrlMap(map);
		return surlhm;
	}
}
