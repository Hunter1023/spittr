package com.hunter.spittr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Spittle> getSpittleList(int pageNum) {

        //提供 页码和每页显示的数量参数
        PageHelper.startPage(pageNum, 10);
        //startPage方法之后紧跟的查询 才是 分页查询
        List<Spittle> spittles = spittleDao.getSpittleList();
        //使用pageInfo包装查询后的结果，只需将pageInfo交给页面即可
        PageInfo<Spittle> pageInfo = new PageInfo<Spittle>(spittles);

        return pageInfo;
    }

    @Transactional
    public PageInfo<Spittle> getSpittlesByUserId(int pageNum, long userId) {
        PageHelper.startPage(pageNum, 10);

        List<Spittle> spittles = spittleDao.getSpittlesByUserId(userId);
        PageInfo<Spittle> pageInfo = new PageInfo<Spittle>(spittles);

        return pageInfo;
    }

    @Transactional
    public void publishSpittle(Spittle spittle) {
            spittleDao.addSpittle(spittle);
    }
}
