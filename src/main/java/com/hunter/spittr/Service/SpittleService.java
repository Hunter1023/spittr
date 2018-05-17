package com.hunter.spittr.Service;

import com.hunter.spittr.meta.Spittle;

import java.util.List;

public interface SpittleService {
    List<Spittle> getSpittleList(long max, int count);

    Spittle getSpittle(long id);
}
