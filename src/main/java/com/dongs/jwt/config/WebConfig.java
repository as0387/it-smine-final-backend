package com.dongs.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("file:///C:/Users/ImD/Desktop/졸업작품/final_itsmine_prj/it'smine_final_backend/ItsminePrj_final/src/main/resources/upload/")
	private String uploadFolderPath;

	@Value("/upload/**")
	private String getUploadPath;

	@Value("file:///C:/Users/ImD/Desktop/졸업작품/final_itsmine_prj/it'smine_final_backend/ItsminePrj_final/src/main/resources/upload/public/")
	private String publicFolderPath;

	@Value("/upload/public/**")
	private String getPublicPath;

	@Value("file:///C:/Users/ImD/Desktop/졸업작품/final_itsmine_prj/it'smine_final_backend/ItsminePrj_final/src/main/resources/upload/profile/")
	private String profileFolderPath;

	@Value("/upload/profile/**")
	private String getProfilePath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		if (getUploadPath != null) {
			registry.addResourceHandler(getUploadPath).addResourceLocations(uploadFolderPath);
		} else if (getPublicPath != null) {
			registry.addResourceHandler(getPublicPath).addResourceLocations(publicFolderPath);
		} else {
			registry.addResourceHandler(getProfilePath).addResourceLocations(profileFolderPath);
		}

	}
}
