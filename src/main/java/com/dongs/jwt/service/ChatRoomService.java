package com.dongs.jwt.service;

import com.dongs.jwt.domain.chat.ChatRoom;
import com.dongs.jwt.domain.chat.ChatRoomJoin;
import com.dongs.jwt.domain.user.User;
import com.dongs.jwt.repository.ChatRoomJoinRepository;
import com.dongs.jwt.repository.ChatRoomRepository;
import com.dongs.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final UserRepository userRepository;
    private final ChatRoomJoinRepository chatRoomJoinRepository;
    private final ChatRoomRepository chatRoomRepository;


    @Transactional
    public ChatRoom openChatRoom(String chatRoomId) {//1:1채팅
    	
        return chatRoomRepository.findById(Long.valueOf(chatRoomId)).orElseThrow(() -> new IllegalArgumentException(chatRoomId + "는 존재하지 않습니다."));
    }
}
