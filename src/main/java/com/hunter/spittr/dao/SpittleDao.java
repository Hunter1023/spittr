package com.hunter.spittr.dao;

import com.hunter.spittr.meta.Spittle;

import java.util.List;

public interface SpittleDao {
    List<Spittle> getSpittleList(long max, int count);

    Spittle getSpittle(long id);
}
