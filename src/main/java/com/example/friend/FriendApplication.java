package com.example.friend;

import com.example.friend.friend.Models.Friend;
import com.example.friend.friend.Repositories.FriendRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }

    @Bean
    public CommandLineRunner friend(FriendRepository repository) {
        return (args) -> {
            // save a new friends
            repository.deleteAll();
            repository.save(new Friend("Hassan Hamid", "hassan@gmail.com", "7634234356"));
            repository.save(new Friend("Emil Eyre", "emil@gmail.com", "703736464634"));
            repository.save(new Friend("Jason Da", "jason@gmail.com", "7634739284"));
            repository.save(new Friend("Erik Bovary", "erik@gmail.com", "7612332145"));
            repository.save(new Friend("Madison Parker", "madison@gmail.com", "7098778934"));
        };
    }

}
