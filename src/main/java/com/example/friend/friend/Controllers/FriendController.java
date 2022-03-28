package com.example.friend.friend.Controllers;

import com.example.friend.friend.Models.Friend;
import com.example.friend.friend.Response.Response;
import com.example.friend.friend.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="")
public class FriendController {

    private final FriendService friendService;


    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to my friend phone list page";
    }

    @GetMapping("/freind/add")
    public String addNewFriend(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String telephoneNumber){
        return friendService.addNewFriend(name,email,telephoneNumber);
    }

    @RequestMapping("/friend/allfriends")
    public Iterable<Friend> getFriends() {
        return friendService.getAllFriends();
    }

    @GetMapping( "/friend/friend")
    public Iterable<Friend> getByName(@RequestParam(required = false) String name){
        return friendService.getAllFriendsByName(name);
    }

    @GetMapping( "/friend/getfriendbynumber")
    public Iterable<Friend> getByNumber(@RequestParam(required = false) String number){
        return friendService.getAllFriendsByNumber(number);
    }

    @GetMapping(value = "/friend/delete/{id}")
    public String deleteFriend(@PathVariable Long id) {
        return friendService.deleteFriend(id);
    }

    /*@PutMapping(path = "friend/update/{friendId}")
    public void updateStudent(
            @PathVariable("friendId") long friendId,
            @RequestParam(required = false) String telephoneNumber){
        friendService.updateStudent(friendId, telephoneNumber);
    }*/

    @PutMapping(path = "/friend/update/{friendId}")
    public Response updateStudent(@PathVariable Long friendId,
                                  @RequestBody Friend friend){
        return friendService.updateStudent(friendId, friend);
    }
}
