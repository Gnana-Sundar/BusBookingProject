package com.BookingAppDatabase.BookingAppDatabase.Controller;

import com.BookingAppDatabase.BookingAppDatabase.Models.LoginRequest;
import com.BookingAppDatabase.BookingAppDatabase.Models.Users;
import com.BookingAppDatabase.BookingAppDatabase.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/loginPage")
    public String getLoginPage(Model model) {
        return "theaters/login";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        return "theaters/register";
    }

    @PostMapping("/login")
    public String getLoginResponse(@ModelAttribute LoginRequest loginRequest, RedirectAttributes redirectAttributes) {
        String status = userService.getLoginResponse(loginRequest);
        if (status.equals("success")) {
            redirectAttributes.addFlashAttribute("message", "Login Successfully...");
            return "redirect:/theaters/getTheaters";
        } else {
            redirectAttributes.addFlashAttribute("message", "Login Failed...");
            return "theaters/login";
        }
    }

    @PostMapping("/register")
    public String getRegisterResponse(@ModelAttribute Users users, RedirectAttributes redirectAttributes) {
        String status = userService.getRegisterResponse(users);
        if (status.equals("success")) {
            redirectAttributes.addFlashAttribute("messages", "Register Successfully...");
            return "theaters/login";
        } else {
            redirectAttributes.addFlashAttribute("messages", "Register Failed...");
            return "theaters/register";
        }
    }
}
