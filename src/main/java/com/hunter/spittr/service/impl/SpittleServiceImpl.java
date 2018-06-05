package com.hunter.spittr.service.impl;

import com.hunter.spittr.service.SpittleService;
import com.hunter.spittr.dao.SpittleDao;
import com.hunter.spittr.meta.Spittle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpittleServiceImpl implements SpittleService {
    @Resource
    private SpittleDao spittleDao;


    @Transactional
    public List<Spittle> getSpittleList(long max, int count) {

        return spittleDao.getSpittleList(max, count);
    }

    @Transactional
    public List<Spittle> getSpittlesByUserId(long max, long userId, int count) {
        return spittleDao.getSpittlesByUserId(max, userId, count);
    }

    @Transactional
    public void publishSpittle(Spittle spittle) {
            spittleDao.addSpittle(spittle);
    }
}
