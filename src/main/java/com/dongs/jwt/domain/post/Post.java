package com.dongs.jwt.domain.post;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.dongs.jwt.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;
	
	@Column
	private int price;
	
	@Column
    private String imageUrl;

//	@OneToMany(mappedBy = "post", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
//	private List<Photo> photos = new ArrayList<>();
//
//	// Board에서 파일 처리 위함
//	public void addPhoto(Photo photo) {
//		this.photos.add(photo);
//
//		// 게시글에 파일이 저장되어있지 않은 경우
//		if (photo.getPost() != this)
//			// 파일 저장
//			photo.setPost(this);
//	}

	@CreationTimestamp
	private Timestamp createDate;
	
	@LastModifiedDate
    private LocalDateTime modifiedDate;
}