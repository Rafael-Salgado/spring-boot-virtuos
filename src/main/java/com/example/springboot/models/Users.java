package com.example.springboot.models;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String user_name;
    @Column
    private String user_lastname;
    @Column
    private String user_email;
    @Column
    private long user_phone;
    @Column
    private String user_password;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, long phone, String password) {
        this.user_name = firstName;
        this.user_lastname = lastName;
        this.user_email = email;
        this.user_phone = phone;
        this.user_password = password;
    }

    public Users(int id, String firstName, String lastName, String email, long phone, String password) {
        this.id=id;
        this.user_name = firstName;
        this.user_lastname = lastName;
        this.user_email = email;
        this.user_phone = phone;
        this.user_password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(long user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
