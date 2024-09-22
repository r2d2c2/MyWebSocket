package study.mywebsocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.mywebsocket.entity.user_chat;

public interface UserCharRepository extends JpaRepository<user_chat, Long> {
}
