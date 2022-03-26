package com.example.friend.friend.Controllers;

import com.example.friend.friend.Models.Friend;
import com.example.friend.friend.Repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/demo")
public class FriendControllerDatabase {


    private final FriendRepository friendRepository;

    @Autowired
    public FriendControllerDatabase(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @GetMapping("/add")
    public String addNewFriend(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String telephoneNumber){
        Friend friend = new Friend(name, email, telephoneNumber);

        friendRepository.save(friend);

        return "Saved" ;
    }
}
