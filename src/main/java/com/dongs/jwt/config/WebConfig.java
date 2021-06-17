package com.dongs.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Value("/app/resources/upload/")
	private String uploadFolderPath;
	
	@Value("/upload/**")
	private String getUploadPath;
	
	@Value("/app/resources/upload/banners")
	private String bannersFolderPath;
	
	@Value("/upload/banners/**")
	private String getBannerPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		if (getUploadPath != null) {
			registry.addResourceHandler(getUploadPath)
			.addResourceLocations(uploadFolderPath);
		} else {
			registry.addResourceHandler(getBannerPath)
			.addResourceLocations(bannersFolderPath);
		}
		
	}
}
