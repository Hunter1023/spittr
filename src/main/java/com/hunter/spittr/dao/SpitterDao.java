package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spitter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SpitterDao {
    @Insert("INSERT INTO Spitter(headIcon, username, password, email) " +
            "VALUE (#{headIcon}, #{username}, #{password}, #{email})")
    int addSpitter(Spitter spitter);

    @Select("SELECT * FROM Spitter WHERE username=#{username}")
    Spitter getByUsername(String username);

    @Select("SELECT * FROM Spitter WHERE id=#{userId}")
    Spitter getByUserId(long userId);

    @Select("SELECT * FROM Spitter WHERE username=#{username} AND password=#{password}")
    Spitter verifySpitter(Spitter spitter);
}
