package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spittle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpittleDao {

//    //获取最新的spittle列表分页(默认10条动态)
//    @Select("SELECT * FROM Spittle ORDER BY time DESC LIMIT 10")
//    List<Spittle> getRecentList();


    //获取指定分页的spittle列表
    @Select("SELECT le.id as id, message, time, userId, nickname, thumbnail " +
            "FROM Spittle le LEFT JOIN Spitter er ON le.userId = er.id " +
            "WHERE le.id < #{max} ORDER BY time DESC LIMIT #{count}")
//    @Options(useGeneratedKeys = true)
    List<Spittle> getSpittleList(@Param("max") long max, @Param("count") int count);

    //获取某用户发布过的spittle列表
    @Select("SELECT le.id as id, message, time, userId, nickname, thumbnail " +
            "FROM Spittle le LEFT JOIN Spitter er ON le.userId = er.id " +
            "WHERE le.id < #{max} AND le.userId = #{userId} " +
            "ORDER BY time DESC LIMIT #{count}")
    List<Spittle> getSpittlesByUserId(@Param("max") long max,
                                      @Param("userId") long userId,
                                      @Param("count") int count);


    @Insert("INSERT INTO Spittle(message, time, userId) VALUES (#{message}, #{time}, #{userId})")
    int addSpittle(Spittle spittle);
}
