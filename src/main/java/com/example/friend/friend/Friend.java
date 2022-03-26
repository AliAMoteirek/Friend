package com.example.friend.friend;

import lombok.Data;

@Data
public class Friend {
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
}
