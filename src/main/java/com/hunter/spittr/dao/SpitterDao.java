package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spitter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SpitterDao {
    @Insert("INSERT INTO Spitter(username, password, email) " +
            "VALUE (#{username}, #{password}, #{email})")
    int addSpitter(@Param("username") String username,
                   @Param("password") String password,
                   @Param("email") String email);

    @Select("SELECT * FROM Spitter WHERE username=#{username}")
    Spitter getByUsername(String username);

    @Select("SELECT * FROM Spitter WHERE id=#{userId}")
    Spitter getByUserId(long userId);

    @Select("SELECT * FROM Spitter WHERE username=#{username} AND password=#{password}")
    Spitter verifySpitter(@Param("username") String username, @Param("password") String password);
}
