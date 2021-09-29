package com.dongs.jwt.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongs.jwt.domain.user.User;
import com.dongs.jwt.repository.UserRepository;
import com.dongs.jwt.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * 회원정보, 회원수정 하지 않고 간단하게 구현!!
 * 그래서 Service 따로 안만들었음.
 */

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;
	private final HttpSession session;
	
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody User user) {
		System.out.println("회원가입가즈아아아");
		userService.회원가입(user);
		return new ResponseEntity<String>("ok", HttpStatus.CREATED);
	}
	
}
