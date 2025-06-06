package com.example.demo.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	String path = "file:/C:\\uploadfile\\";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/upload/**")
				.addResourceLocations(path);
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	
	
}
