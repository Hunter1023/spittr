package com.hunter.spittr.service.impl;

import com.hunter.spittr.service.SpittleService;
import com.hunter.spittr.dao.SpittleDao;
import com.hunter.spittr.meta.Spittle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SpittleServiceImpl implements SpittleService {
    @Resource
    private SpittleDao spittleDao;


    @Override
    public List<Spittle> getSpittleList(long max, int count) {

        return spittleDao.getSpittleList(max, count);
    }

//    @Override
//    public Spittle getSpittle(long id) {
//        return spittleDao.getSpittle(id);
//    }

    @Override
    public void publishSpittle(Spittle spittle) {

        //如果已有的动态中，没有与打算发表的动态相同，则将spittle传入数据库
        if(spittleDao.getSpittle(spittle.getMessage()) == null){
            spittleDao.addSpittle(spittle);
        }
    }
}
