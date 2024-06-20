package com.example.demofinalclassvueproject.repository;

import com.example.demofinalclassvueproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = "INSERT INTO user (username, tel, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getTel(), user.getPassword());
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
    }

    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setTel(rs.getString("tel"));
        user.setPassword(rs.getString("password"));
        return user;
    };
}
