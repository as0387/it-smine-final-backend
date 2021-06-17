package com.dongs.jwt.web;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dongs.jwt.domain.post.Banner;
import com.dongs.jwt.repository.PhotoRepository;
import com.dongs.jwt.service.PhotoService;

@RestController
public class PhotoController {
	
	@Autowired
	PhotoService bannerService; 
	
	@Autowired
	PhotoRepository photoRepository;
	
	
	@GetMapping("/getBanners")
	public List<Banner> banners(){
		return bannerService.배너목록();
	}
	 
}
