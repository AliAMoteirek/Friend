package com.example.friend.friend.Repositories;

import com.example.friend.friend.Models.Friend;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {

    @org.springframework.data.jpa.repository.Query("select f from Friend f where f.name = ?1")
    @Query
    List<Friend> getFrindsByName(String name);

    @org.springframework.data.jpa.repository.Query("select f from Friend f where f.email = ?1")
    @Query
    List<Friend> getFrindByEmail(String email);

    @org.springframework.data.jpa.repository.Query("select f from Friend f where f.telephoneNumber = ?1")
    @Query
    List<Friend> getFrindsByTelephoneNumber(String telephoneNumber);

    Optional<Friend> getByTelephoneNumber(String telephoneNumber);

}
