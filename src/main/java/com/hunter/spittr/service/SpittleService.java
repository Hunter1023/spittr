package com.hunter.spittr.service;

import com.github.pagehelper.PageInfo;
import com.hunter.spittr.meta.Spittle;

import java.util.Date;
import java.util.List;

public interface SpittleService {

    PageInfo getSpittleList(int pageNum);

    PageInfo getSpittlesByUserId(int pageNum, long userId);

    void publishSpittle(Spittle spittle);

}
