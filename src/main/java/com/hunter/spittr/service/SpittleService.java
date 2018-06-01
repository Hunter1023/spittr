package com.hunter.spittr.service;

import com.hunter.spittr.meta.Spittle;

import java.util.Date;
import java.util.List;

public interface SpittleService {

    List<Spittle> getSpittleList(long max, int count);

    List<Spittle> getSpittlesByUserId(long max, long userId, int count);

    void publishSpittle(Spittle spittle);

}
