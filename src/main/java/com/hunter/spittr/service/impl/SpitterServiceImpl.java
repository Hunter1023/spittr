package com.hunter.spittr.service.impl;

import com.hunter.spittr.service.SpitterService;
import com.hunter.spittr.dao.SpitterDao;
import com.hunter.spittr.meta.Spitter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpitterServiceImpl implements SpitterService {

    @Resource
    private SpitterDao spitterDao;

    @Override
    public boolean isRegistered(Spitter spitter) {
        //如果用户名或昵称已被注册，返回false
        if(spitterDao.getByUsernameOrNickname(spitter) != null){
            return true;
        }
        return false;
    }

    //将用户信息添加到数据库
    @Override
    public void register(Spitter spitter) {
        spitterDao.addSpitter(spitter);
    }

    //获取用户信息，展示于用户个人主页
    @Override
    public Spitter getByNickname(String nickname) {
        return spitterDao.getByNickname(nickname);
    }

    @Override
    public Spitter verifySpitter(Spitter spitter) {
        return spitterDao.verifySpitter(spitter);
    }
}
