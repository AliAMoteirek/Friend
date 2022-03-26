package com.example.friend.friend.Controllers;

import com.example.friend.friend.FriendDao;
import com.example.friend.friend.Models.Friend;
import com.example.friend.friend.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendController {

    FriendDao friendDAO = new FriendDao();
    List<Friend> friendList = friendDAO.getAllFriends();

    @RequestMapping(value = "/friend")
    public Friend oneFriend() {
        return new Friend(1, "Yasser", "Stockholm", "7656788872");
    }

    @RequestMapping("/friends")
    public List<Friend> index() {
        return friendList;
    }

    @RequestMapping("/friend/{id}")
    public Friend getBookById(@PathVariable int id) {
        Friend result = new Friend();
        for (Friend friend : friendList) {
            if (friend.getId() == id) {
                result = friend;
            }
        }
        return result;
    }

    @RequestMapping("/friendssHTML")
    public String getBooksHTML() {
        StringBuilder result = new StringBuilder("<HTML><HEAD><TITLE>Friends</TITLE></HEAD><BODY><TABLE>");
        for (Friend friend : friendList) {
            result.append("<TR><TD>").append(friend.getId()).append("</TD><TD>").append(friend.getName()).append("</TD><TD>").append(friend.getAddress()).append("</TD></TR>");
        }
        result.append("</TABLE></HTML>");
        return result.toString();
    }

    @RequestMapping("/friend/{id}/delete")
    public Response deleteBookById(@PathVariable("id") int id) {
        Response response = new Response("Friend deleted", Boolean.FALSE);
        int indexToRemove = -1;

        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).getId() == id) {
                indexToRemove = i;
            }
        }
        if (indexToRemove != -1) {
            friendList.remove(indexToRemove);
            response.setStatus(Boolean.TRUE);
        }

        return response;
    }

    @PostMapping("/friend/add")
    public Response addNewFriend(@RequestBody Friend friend) {
        System.out.println(friend.getId() + " " + friend.getName() + " " + friend.getAddress() + " " + friend.getTelephoneNumber());

        Response response = new Response("Friend added", Boolean.FALSE);
        friendList.add(friend);
        response.setStatus(Boolean.TRUE);

        return response;
    }

    @PostMapping("/friend/update")
    public Response upsertFriend(@RequestBody Friend friend) {

        int friendId = -10;
        for (int i = 0; i < friendList.size(); i++){
            if (friendList.get(i).getId() == friend.getId()){
                friendId = i;
            }
        }

        if(friendId == -10){
            friendList.add(friend);
            return new Response("New Friend added", true);
        } else{
            friendList.set(friendId, friend);
            return new Response("Freind Updated", true);
        }
    }

}
