package com.example.buoi2demo;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<User> userList = new ArrayList<>();
    public String UserName;
    public String Email;
    public String Password;

    public User(String userName, String email, String password) {
        UserName = userName;
        Email = email;
        Password = password;
    }

    public User(String email, String password) {
        Email = email;
        Password = password;
    }
}
