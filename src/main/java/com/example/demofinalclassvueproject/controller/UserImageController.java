package com.example.demofinalclassvueproject.controller;

import com.example.demofinalclassvueproject.model.UserInfo;
import com.example.demofinalclassvueproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Base64;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserImageController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserPic")
    public ResponseEntity<?> getUserPic(@RequestParam String username) {
        try {
            UserInfo userInfo = userService.getUserInfoByUsername(username);
            if (userInfo != null && userInfo.getPic() != null) {
                // 直接返回从数据库中获取的 Base64 编码字符串
                String base64Encoded = new String(userInfo.getPic(), "UTF-8");
                return new ResponseEntity<>(base64Encoded, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("获取用户头像失败: " + e.getMessage());
        }
    }
}

