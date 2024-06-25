package com.example.demofinalclassvueproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminuser")
public class AdminUserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, Object> payload) {
        String adminName = (String) payload.get("username");
        String adminPsw = (String) payload.get("password");

        // 加密密码
        String encodedPsw = passwordEncoder.encode(adminPsw);
        System.out.println("Encoded Password: " + encodedPsw);

        String sql = "INSERT INTO adminuser (adminname, adminpsw) VALUES (?, ?)";
        int result = jdbcTemplate.update(sql, adminName, encodedPsw);

        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "注册成功");
            response.put("success", true);
        } else {
            response.put("message", "注册失败");
            response.put("success", false);
        }
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> user) {
        String adminName = user.get("username");
        String adminPsw = user.get("password");

        String sql = "SELECT * FROM adminuser WHERE adminname = ?";
        Map<String, Object> response = new HashMap<>();

        try {
            Map<String, Object> result = jdbcTemplate.queryForMap(sql, adminName);
            String storedPassword = (String) result.get("adminpsw");
            System.out.println("Stored Password: " + storedPassword);
            System.out.println("Input Password: " + adminPsw);

            if (passwordEncoder.matches(adminPsw, storedPassword)) {
                response.put("success", true);
                response.put("data", result);
            } else {
                response.put("success", false);
                response.put("message", "用户名或密码错误");
            }
        } catch (EmptyResultDataAccessException e) {
            response.put("success", false);
            response.put("message", "用户名或密码错误");
        }

        return response;
    }


}
