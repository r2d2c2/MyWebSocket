package study.mywebsocket.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import study.mywebsocket.dto.Greeting;
import study.mywebsocket.dto.HelloMessage;
import study.mywebsocket.entity.user_chat;
import study.mywebsocket.repository.UserCharRepository;

@Controller
@RequiredArgsConstructor
public class GreetingController {
    private final UserCharRepository UserCharRepository;

    /*@MessageMapping("/hello")
        @SendTo("/topic/greetings")
        public Greeting greeting(HelloMessage message) throws Exception {
            Thread.sleep(1000); // simulated delay
            return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        }*/
    @SneakyThrows//Thread.sleep 예외처리
    @MessageMapping("/hello") // 웹소켓 메시지를 받도록 선언
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message, SimpMessageHeaderAccessor headerAccessor) {//HelloMessage 타입으로 받고
        String id = headerAccessor.getSessionId();
        UserCharRepository.save(user_chat.builder().name(id).message(message.getName()).build());
        return new Greeting(id+" : " + message.getName());
        //Greeting 타입으로 리턴
    }
}