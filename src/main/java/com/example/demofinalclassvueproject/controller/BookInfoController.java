package com.example.demofinalclassvueproject.controller;

import com.example.demofinalclassvueproject.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @GetMapping("/search")
    public List<BookInfo> searchBooks(@RequestParam String query) {
        String sql = "SELECT * FROM bookinfo WHERE booktitle LIKE ?";
        String likeQuery = "%" + query + "%";
        return jdbcTemplate.query(sql, new Object[]{likeQuery}, new BookInfoRowMapper());
    }

    @GetMapping("/books")
    public List<BookInfo> getAllBooks() {
        String sql = "SELECT * FROM bookinfo";
        return jdbcTemplate.query(sql, new BookInfoRowMapper());
    }

    private static class BookInfoRowMapper implements RowMapper<BookInfo> {
        @Override
        public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(rs.getInt("id"));
            bookInfo.setBookpic(rs.getBytes("bookpic"));
            bookInfo.setBooktitle(rs.getString("booktitle"));
            bookInfo.setBookinfo(rs.getString("bookinfo"));
            return bookInfo;
        }
    }
}
