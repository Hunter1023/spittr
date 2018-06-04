package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spitter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface SpitterDao {
    //添加用户
    @Insert("INSERT INTO Spitter(headIcon, thumbnail, username, password, email, nickname) " +
            "VALUE (#{headIcon}, #{thumbnail}, #{username}, #{password}, #{email}, #{nickname})")
    void addSpitter(Spitter spitter);

    //验证用户名或昵称是否已被注册
    @Select("SELECT * FROM Spitter WHERE username=#{username} OR nickname=#{nickname}")
    Spitter getByUsernameOrNickname(Spitter spitter);


    @Select("SELECT * FROM Spitter WHERE id=#{userId}")
    Spitter getByUserId(long userId);

    //获取用户信息，展示于用户个人主页
    @Select("SELECT * FROM Spitter WHERE nickname=#{nickname}")
    Spitter getByNickname(String nickname);

    //获取完整的用户信息（邮箱，id，头像等）
    @Select("SELECT * FROM Spitter WHERE username=#{username} AND password=#{password}")
    Spitter getSpitter(Spitter spitter);

    @Select("SELECT password From Spitter WHERE username=#{username}")
    String getPassword(String username);
}
