package com.example.demofinalclassvueproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookinfo")
public class BookInfoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/upload")
    public String uploadBookInfo(@RequestBody Map<String, Object> payload) {
        try {
            String bookPicBase64 = (String) payload.get("bookpic");
            String bookTitle = (String) payload.get("booktitle");
            String bookInfo = (String) payload.get("bookinfo");

            // Decode Base64 image
            byte[] bookPic = Base64.getDecoder().decode(bookPicBase64);

            // Save to database
            String sql = "INSERT INTO bookinfo (bookpic, booktitle, bookinfo) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, bookPic, bookTitle, bookInfo);

            return "书籍信息上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "书籍信息上传失败: " + e.getMessage();
        }
    }
}
