package com.hunter.spittr.Service.impl;

import com.hunter.spittr.Service.SpitterService;
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
        String password = spitter.getPassword();
        //如果用户名已被注册，返回false
        this.spitter = spitterDao.getSpitter(username);
        if(this.spitter != null){
            return true;
        }
        spitterDao.addSpitter(username, password);
        return false;
    }

    @Override
    public Spitter getByUsername(String username) {
        return spitterDao.getSpitter(username);
    }
}
