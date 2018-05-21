package com.hunter.spittr.service;

import com.hunter.spittr.meta.Spittle;

import java.util.Date;
import java.util.List;

public interface SpittleService {

    List<Spittle> getSpittleList(long max, int count);

//    Spittle getSpittle(long id);

    void publishSpittle(Spittle spittle);

}
