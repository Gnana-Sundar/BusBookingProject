package com.BookingAppDatabase.BookingAppDatabase.Models;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
    private long mobile_no;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(long mobile_no, String password) {
        this.mobile_no = mobile_no;
        this.password = password;
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
        return "LoginRequest{" +
                "mobile_no=" + mobile_no +
                ", password='" + password + '\'' +
                '}';
    }
}
