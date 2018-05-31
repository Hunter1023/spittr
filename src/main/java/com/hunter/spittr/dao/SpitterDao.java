package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spitter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SpitterDao {
    //添加用户
    @Insert("INSERT INTO Spitter(headIcon, username, password, email, nickname) " +
            "VALUE (#{headIcon}, #{username}, #{password}, #{email}, #{nickname)")
    int addSpitter(Spitter spitter);

    //验证用户名或昵称是否已被注册
    @Select("SELECT * FROM Spitter WHERE username=#{username} OR nickname=#{nickname}")
    Spitter getByUsernameOrNickname(Spitter spitter);


    @Select("SELECT * FROM Spitter WHERE id=#{userId}")
    Spitter getByUserId(long userId);

    //获取用户信息，展示于用户个人主页
    @Select("SELECT * FROM Spitter WHERE nickname=#{nickname}")
    Spitter getByNickname(String nickname);

    //验证登录信息
    @Select("SELECT * FROM Spitter WHERE username=#{username} AND password=#{password}")
    Spitter verifySpitter(Spitter spitter);
}
