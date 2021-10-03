package com.dongs.jwt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongs.jwt.domain.post.NomalAuctionPost;
import com.dongs.jwt.domain.post.Post;
import com.dongs.jwt.domain.user.User;
import com.dongs.jwt.repository.NomalAuctionPostRepository;
import com.dongs.jwt.repository.PostRepository;
import com.dongs.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	@Transactional
	public void 글쓰기(Post post, User principal) {
		post.setUser(principal);
		postRepository.save(post);
	}
	
	@Transactional
	public void 일반경매상품등록(Post post, User principal) {
		post.setUser(principal);
		postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
	public Page<Post> 글목록(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Post 글상세(int id) {
		return postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id+"는 존재하지 않습니다."));
	}
	
	@Transactional
	public int 글수정(Post post, int id, User principal) {
		Post postEntity = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id+"는 존재하지 않습니다."));
		
		if(postEntity.getUser().getId() == principal.getId()) {
			postEntity.setTitle(post.getTitle());
			postEntity.setDescription(post.getDescription());
			postEntity.setPrice(post.getPrice());
			return 1;
		}else {
			return 0;
		}
	}
	
//	@Transactional
//	public int 입찰하기(Post post, int id) {
//		Post postEntity = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id+"는 존재하지 않습니다."));
//			postEntity.setBid(post.getBid());
//			postEntity.setBidderId(post.getBidderId());
//			return 1;
//	}
	
	@Transactional
	public int 입찰하기(Post post, int id) {
		Post postEntity = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id+"는 존재하지 않습니다."));
		User BidderEntity = userRepository.findById(post.getBidderId()).orElseThrow(()-> new IllegalArgumentException(id+"는 존재하지 않습니다."));;
			postEntity.setBid(post.getBid());
			postEntity.setBidder(BidderEntity);
			return 1;
	}
	
	@Transactional
	public int 글삭제(int id, User principal) {
		// 동일인 체크
		Post postEntity = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id+"는 존재하지 않습니다."));
		if(postEntity.getUser().getId() == principal.getId()) {
			postRepository.deleteById(id);
			return 1;
		}else {
			return 0;
		}
	}
}
