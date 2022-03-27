package com.example.friend.friend.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "friend")
@Data
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;

    public Friend() {
    }

    public Friend(Long id, String name, String email, String telephoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public Friend(String name, String email, String telephoneNumber) {
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }
}
