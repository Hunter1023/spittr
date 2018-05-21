package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spitter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SpitterDao {
    @Insert("INSERT INTO Spitter(username, password) " +
            "VALUE (#{username}, #{password}, #{email})")
    int addSpitter(@Param("username") String username,
                   @Param("password") String password,
                   @Param("email") String email);

    @Select("SELECT * FROM Spitter WHERE username=#{username}")
    Spitter getSpitter(String username);
}
