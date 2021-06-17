package com.dongs.jwt.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "postId")
//    private Post post;

    @Column(nullable = false)
    private String origFilename;  // 파일 원본명
    
    @Column(nullable = false)
    private String filename; //중복을 피하기위해 변경한 파일명

    @Column(nullable = false)
    private String imageUrl;  // 파일 저장 경로

//    private Long fileSize;

    @Builder
    public Photo(Long id, String origFilename, String filename, String imageUrl) {
        this.id = id;
        this.origFilename = origFilename;
        this.filename = filename;
        this.imageUrl = imageUrl;
    }

//    // Board 정보 저장
//    public void setPost(Post post){
//        this.post = post;
//
//	// 게시글에 현재 파일이 존재하지 않는다면
//        if(!post.getPhotos().contains(this))
//            // 파일 추가
//        	post.getPhotos().add(this);
//    }
}