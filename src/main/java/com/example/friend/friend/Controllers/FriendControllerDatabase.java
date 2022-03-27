package com.example.friend.friend.Controllers;

import com.example.friend.friend.Models.Friend;
import com.example.friend.friend.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/demo")
public class FriendControllerDatabase {

    private final FriendService friendService;


    @Autowired
    public FriendControllerDatabase(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/add")
    public String addNewFriend(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String telephoneNumber){
        return friendService.addNewFriend(name,email,telephoneNumber);
    }

    @RequestMapping("/allFriends")
    public Iterable<Friend> getFriends() {
        return friendService.getAllFriends();
    }

    @GetMapping( "/friend")
    public Iterable<Friend> getByName(@RequestParam(required = false) String name){
        return friendService.getAllFriendsByName(name);
    }

    @GetMapping( "/getFriendByNumber")
    public Iterable<Friend> getByNumber(@RequestParam(required = false) String number){
        return friendService.getAllFriendsByNumber(number);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteFriend(@PathVariable Long id) {
        return friendService.deleteFriend(id);
    }

    @PutMapping(path = "/update/{friendId}")
    public void updateStudent(
            @PathVariable("friendId") long friendId,
            @RequestParam(required = false) String telephoneNumber){
        friendService.updateStudent(friendId, telephoneNumber);
    }
}
