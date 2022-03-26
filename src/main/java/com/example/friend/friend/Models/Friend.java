package com.example.friend.friend.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "friend")
@Data
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String telephoneNumber;

    public Friend() {
    }

    public Friend(int id, String name, String address, String telephoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public Friend(String name, String address, String telephoneNumber) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
}
