package com.dongs.jwt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongs.jwt.domain.post.Banner;
import com.dongs.jwt.domain.post.Photo;
import com.dongs.jwt.dto.PhotoDto;
import com.dongs.jwt.repository.BannerRepository;
import com.dongs.jwt.repository.PhotoRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PhotoService {
	
	private final PhotoRepository photoRepository;
	private final BannerRepository bannerRepository;


    @Transactional
    public void saveFile(PhotoDto photoDto) {
        photoRepository.save(photoDto.toEntity());
    }

    @Transactional
    public PhotoDto getFile(Long id) {
    	Photo photo = photoRepository.findById(id).get();

    	PhotoDto photoDto = PhotoDto.builder()
                .id(id)
                .origFilename(photo.getOrigFilename())
                .filename(photo.getFilename())
                .imageUrl(photo.getImageUrl())
                .build();
        return photoDto;
    }

	@Transactional(readOnly = true)
	public List<Banner> 배너목록() {
		return bannerRepository.findAll();
	}	
}
