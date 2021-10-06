package com.dongs.jwt.domain.post;

import java.sql.Timestamp;
import java.time.LocalDateTime;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

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
	
	@Column
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;
	
	@Column
    private String imageUrl;
	
	@Column(columnDefinition = "int default 0")
	private int type;
	
	@Column(columnDefinition = "int default 1")
	private int endType;
	 
	 @Column
	 private int price;
	 
	 @Column
	 private int bid;
	 
	 @Column
	 private int bidderId;
	 
	 @Column
	 private int bidLimit;
	 
	 @Column
	 private int minBidUnit;
	 
	 @Column
	 private int endTime;
	 
	@JoinColumn(name = "bidder")
	@ManyToOne
	 private User bidder;
	 
	@CreationTimestamp
	private Timestamp createDate;
	
	@LastModifiedDate
    private LocalDateTime modifiedDate;
}