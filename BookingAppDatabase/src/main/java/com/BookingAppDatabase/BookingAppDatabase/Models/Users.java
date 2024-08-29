package com.BookingAppDatabase.BookingAppDatabase.Models;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private String email_id;
    private long mobile_no;
    private String password;

    public Users() {
    }

    public Users(int user_id, String user_name, String email_id, long mobile_no, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email_id = email_id;
        this.mobile_no = mobile_no;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", email_id='" + email_id + '\'' +
                ", mobile_no=" + mobile_no +
                ", password='" + password + '\'' +
                '}';
    }
}
