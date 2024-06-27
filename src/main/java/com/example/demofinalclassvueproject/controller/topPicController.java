package com.example.demofinalclassvueproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usertoppic")
public class topPicController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public String upload(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String base64Image = request.get("pic");
        // System.out.println(base64Image);
        saveUserInfo(username, base64Image);
        return "上传成功";
    }

    public void saveUserInfo(String username, String base64Image) {
        String sql = "INSERT INTO userinfo (username, pic) VALUES (?, ?)";
        jdbcTemplate.update(sql, username, base64Image);
    }
}

