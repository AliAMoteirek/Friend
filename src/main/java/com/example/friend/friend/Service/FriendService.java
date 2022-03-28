package com.example.friend.friend.Service;

import com.example.friend.friend.Models.Friend;
import com.example.friend.friend.Repositories.FriendRepository;
import com.example.friend.friend.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FriendService {

    private final FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public String addNewFriend(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String telephoneNumber){
        Friend friend = new Friend(name, email, telephoneNumber);

        friendRepository.save(friend);

        return "Saved" ;
    }

    public Iterable<Friend> getAllFriends(){
        System.out.println(friendRepository.findAll());
        return friendRepository.findAll();
    }

    public Iterable<Friend> getAllFriendsByName(String name){
        if(name != null){
            return friendRepository.getFrindsByName(name);
        }
        return null;
    }

    public List<Friend> getAllFriendsByNumber(String number){
        if(number != null){
            return friendRepository.getFrindsByTelephoneNumber(number);
        }
        return null;
    }

    public String deleteFriend(Long id) {
        boolean exists = friendRepository.existsById(id);
        if(!exists){
            return "Friend with id " + id + " does not exists";
        }
        friendRepository.deleteById(id);
        return "Friend is deleted";
    }

   /* @Transactional
    public void updateStudent(long friendId,
                              String telephoneNumber) {
        Friend friend = friendRepository.findById(friendId).orElseThrow(() ->
                new IllegalStateException(
                "Friend with id " + friendId + " does not exists"
        ));

        if(telephoneNumber != null &&
                telephoneNumber.length() > 0 &&
                !Objects.equals(friend.getTelephoneNumber(), telephoneNumber)){
            Optional<Friend> friendOptional = friendRepository.getByTelephoneNumber(telephoneNumber);
            if(friendOptional.isPresent()){
                throw new IllegalStateException("Phone Number taken");
            }
            friend.setTelephoneNumber(telephoneNumber);
        }
    }*/

    @Transactional
    public Response updateStudent(Long friendId, Friend friendInput) {
        Friend friend = friendRepository.findById(friendId).orElse(null);

        if(friend == null){
            return new Response("Friend with id " + friendId + " does not exists", false);
        }

        if(friendInput.getTelephoneNumber() != null &&
                friendInput.getTelephoneNumber().length() > 0 &&
                !Objects.equals(friend.getTelephoneNumber(), friendInput.getTelephoneNumber())){

            Optional<Friend> friendOptional = friendRepository.getByTelephoneNumber(friendInput.getTelephoneNumber());

            if(friendOptional.isPresent()){
                return new Response("Phone Number: " + friendInput.getTelephoneNumber()
                        + " is already taken", false);
            }
            friend.setTelephoneNumber(friendInput.getTelephoneNumber());
        }
        return new Response(friendInput.getName() + "'s phone number is updated to " +
                friendInput.getTelephoneNumber() , true);
    }
}
