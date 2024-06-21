package com.example.demofinalclassvueproject.mapper;

import com.example.demofinalclassvueproject.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("SELECT * FROM userinfo WHERE username = #{username}")
    UserInfo getUserInfoByUsername(String username);
}
