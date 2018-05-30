package com.hunter.spittr.service.impl;

import com.hunter.spittr.service.SpitterService;
import com.hunter.spittr.dao.SpitterDao;
import com.hunter.spittr.meta.Spitter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpitterServiceImpl implements SpitterService {

    private Spitter spitter;

    @Resource
    private SpitterDao spitterDao;

    @Override
    public boolean isRegistered(Spitter spitter) {
        String username = spitter.getUsername();
        //如果用户名已被注册，返回false
        this.spitter = spitterDao.getByUsername(username);
        if(this.spitter != null){
            return true;
        }
        return false;
    }

    @Override
    public void register(Spitter spitter) {
        spitterDao.addSpitter(spitter);
    }

    @Override
    public Spitter getByUsername(String username) {
        return spitterDao.getByUsername(username);
    }

    @Override
    public Spitter getByUserId(Long userId) {
        return spitterDao.getByUserId(userId);
    }

    @Override
    public Spitter verifySpitter(Spitter spitter) {
        return spitterDao.verifySpitter(spitter);
    }
}
