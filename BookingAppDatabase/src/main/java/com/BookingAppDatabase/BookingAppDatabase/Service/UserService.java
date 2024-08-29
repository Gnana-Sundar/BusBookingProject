package com.BookingAppDatabase.BookingAppDatabase.Service;

import com.BookingAppDatabase.BookingAppDatabase.Models.LoginRequest;
import com.BookingAppDatabase.BookingAppDatabase.Models.Users;
import com.BookingAppDatabase.BookingAppDatabase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getLoginResponse(LoginRequest loginRequest){
        boolean status=false;
        List<Users> users = userRepository.findAll();
        for (Users user: users){
            if (loginRequest.getMobile_no()==user.getMobile_no()&&loginRequest.getPassword().equals(user.getPassword())){
                status=true;
            }
        }

        if (status == true){
            return "success";
        }else {
            return "failed";
        }
    }

    public String getRegisterResponse(Users user){
        Users users = new Users();
        users.setUser_name(user.getUser_name());
        users.setEmail_id(user.getEmail_id());
        users.setMobile_no(user.getMobile_no());
        users.setPassword(user.getPassword());
        Users status = userRepository.save(users);

        if (status != null){
            return "success";
        }else {
            return "failed";
        }
    }
}
