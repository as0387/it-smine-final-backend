package com.dongs.jwt.web.chat;

import com.dongs.jwt.config.auth.PrincipalDetails;
import com.dongs.jwt.domain.chat.ChatRoom;
import com.dongs.jwt.domain.user.User;
import com.dongs.jwt.dto.ChatListDto;
import com.dongs.jwt.repository.UserRepository;
import com.dongs.jwt.service.ChatMessageService;
import com.dongs.jwt.service.ChatRoomJoinService;
import com.dongs.jwt.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.AssociationOverride;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomJoinService chatRoomJoinService;
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @GetMapping("/chat-list")
    public ResponseEntity<?> chatList(@AuthenticationPrincipal PrincipalDetails principal){
        User user = principal.getUser();
        List<ChatListDto> list = chatRoomJoinService.getChatRoomList(user);
        return new ResponseEntity<List<ChatListDto>>(list, HttpStatus.OK);
    }

    @PostMapping("/chat/newChat")
    public ResponseEntity<?> createChatRoom(@RequestBody Map<String, Integer> roomUserInfo){
        int userId1 = roomUserInfo.get("userId1");
        int userId2 =roomUserInfo.get("userId2");

        return new ResponseEntity<Long>(chatRoomJoinService.createChatRoom(userId1,userId2), HttpStatus.OK);
    }

    @GetMapping("/chat/{chatRoomId}")
    public ResponseEntity<?> openChatRoom(@PathVariable String chatRoomId){
        return new ResponseEntity<ChatRoom>(chatRoomService.openChatRoom(chatRoomId), HttpStatus.OK);
    }

    @PostMapping("/chat")
    public ResponseEntity<?> sendMessage(@RequestBody Map<String, Object> messageInfo){
    	System.out.println((int)messageInfo.get("writerId"));
    	System.out.println(Long.valueOf(String.valueOf(messageInfo.get("roomId"))));
    	System.out.println((String)messageInfo.get("message"));
        int writerId = (int)messageInfo.get("writerId");
        Long roomId = Long.valueOf(String.valueOf(messageInfo.get("roomId")));
        String message = (String)messageInfo.get("message");
        chatMessageService.sendMessage(writerId,roomId,message);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }


//    @GetMapping("/products/{id}")
//    public ResponseEntity<?> detail(@PathVariable int id) {
//        return new ResponseEntity<Post>(postService.글상세(id), HttpStatus.OK);
//    }
//
//    @PostMapping("/post")
//    public ResponseEntity<?> save(@RequestBody Post post, @AuthenticationPrincipal PrincipalDetails principal) {
//        postService.글쓰기(post, principal.getUser());
//        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
//    }
}
