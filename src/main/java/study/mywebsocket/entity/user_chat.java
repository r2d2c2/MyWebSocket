package study.mywebsocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class user_chat {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    private String name;
    @Getter
    private String message;


}
