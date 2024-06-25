package com.example.demofinalclassvueproject.Dao;

import com.example.demofinalclassvueproject.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookInfoDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BookInfo> findAll() {
        String sql = "SELECT * FROM bookinfo";
        return jdbcTemplate.query(sql, new RowMapper<BookInfo>() {
            @Override
            public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookInfo bookInfo = new BookInfo();
                bookInfo.setId(rs.getInt("id"));
                bookInfo.setBookpic(rs.getBytes("bookpic"));
                bookInfo.setBooktitle(rs.getString("booktitle"));
                bookInfo.setBookinfo(rs.getString("bookinfo"));
                return bookInfo;
            }
        });
    }
}
