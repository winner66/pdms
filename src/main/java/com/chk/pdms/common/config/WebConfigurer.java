package com.chk.pdms.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
class WebConfigurer implements WebMvcConfigurer {
	@Value("${virtual.filePath}")
	private String filePath;

	@Value("${virtual.accessPath}")
	private String accessPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(accessPath).addResourceLocations("file:" + filePath);
	}

}