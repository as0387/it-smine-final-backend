package com.dongs.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongs.jwt.domain.post.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long>{
	
}
