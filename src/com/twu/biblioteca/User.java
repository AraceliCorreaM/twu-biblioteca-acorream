package com.twu.biblioteca;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private boolean isLogged = false;

    public User(String id,String name, String password,String email,String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getId(){
        return this.id;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUserInfo() {
        return String.format("%-20s | %-20s | %-20s | %-20s | %-20s", id, name, password, email, phone);
    }

}