package com.example.demofinalclassvueproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/updata")
public class updataPasswordController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/updatePassword")
    public Map<String, Object> updatePassword(@RequestBody Map<String, Object> payload) {
        String tel = (String) payload.get("tel");
        String newPassword = (String) payload.get("password");

        // Encrypt the new password
        String encodedPassword = passwordEncoder.encode(newPassword);

        String sql = "UPDATE user SET password = ? WHERE tel = ?";
        int result = jdbcTemplate.update(sql, encodedPassword, tel);

        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "密码修改成功");
            response.put("status", "success");
        } else {
            response.put("message", "未找到匹配的用户或密码修改失败");
            response.put("status", "fail");
        }
        return response;
    }
}
