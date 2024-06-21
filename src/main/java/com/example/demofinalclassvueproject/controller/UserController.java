package com.example.demofinalclassvueproject.controller;

import com.example.demofinalclassvueproject.model.User;
import com.example.demofinalclassvueproject.model.UserInfo;
import com.example.demofinalclassvueproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return "注册成功";
        } catch (Exception e) {
            return "注册失败: " + e.getMessage();
        }
    }

}
