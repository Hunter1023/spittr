package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spittle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpittleDao {

//    //获取最新的spittle列表分页(默认20条动态)
//    @Select("SELECT * FROM Spittle ORDER BY time DESC LIMIT 20")
//    List<Spittle> getRecentList();


    //获取指定分页的spittle列表
    @Select("SELECT * FROM Spittle WHERE id < #{max} ORDER BY time DESC LIMIT #{count}")
//    @Options(useGeneratedKeys = true)
    List<Spittle> getSpittleList(@Param("max") long max, @Param("count") int count);

    //获取某个指定的spittle
    @Select("SELECT * FROM Spittle WHERE message=#{message}")
    Spittle getSpittle(String message);


    @Insert("INSERT INTO Spittle(message, time) VALUES (#{message}, #{time})")
    int addSpittle(Spittle spittle);
}
