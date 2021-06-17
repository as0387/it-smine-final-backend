package com.dongs.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Value("file:///C:/Users/ImD/Desktop/SpringOauth2.0/jwt/src/main/resources/upload/")
	private String uploadFolderPath;
	
	@Value("/upload/**")
	private String getUploadPath;
	
	@Value("file:///C:/Users/ImD/Desktop/SpringOauth2.0/jwt/src/main/resources/upload/banners")
	private String bannersFolderPath;
	
	@Value("/upload/banners/**")
	private String getBannerPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		 String path = System.getProperty("user.dir");
		System.out.println(path);
		if (getUploadPath != null) {
			registry.addResourceHandler(getUploadPath)
			.addResourceLocations(uploadFolderPath);
		} else {
			registry.addResourceHandler(getBannerPath)
			.addResourceLocations(bannersFolderPath);
		}
		
	}
}
