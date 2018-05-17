package com.hunter.spittr.Service.impl;

import com.hunter.spittr.Service.SpittleService;
import com.hunter.spittr.dao.SpittleDao;
import com.hunter.spittr.meta.Spittle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpittleServiceImpl implements SpittleService {
    @Resource
    private SpittleDao spittleDao;


    @Override
    public List<Spittle> getSpittleList(long max, int count) {
        return spittleDao.getSpittleList(max, count);
    }

    @Override
    public Spittle getSpittle(long id) {
        return spittleDao.getSpittle(id);
    }
}
