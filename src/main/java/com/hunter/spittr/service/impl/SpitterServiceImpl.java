package com.hunter.spittr.service.impl;

import com.hunter.spittr.service.SpitterService;
import com.hunter.spittr.dao.SpitterDao;
import com.hunter.spittr.meta.Spitter;
import com.hunter.spittr.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SpitterServiceImpl implements SpitterService {

    @Resource
    private SpitterDao spitterDao;

    @Transactional
    public boolean isRegistered(Spitter spitter) {
        //如果用户名或昵称已被注册，返回false
        if (spitterDao.getByUsernameOrNickname(spitter) != null) {
            return true;
        }
        return false;
    }

    //将用户信息添加到数据库
    @Transactional
    public void register(Spitter spitter) {
        spitter.setPassword(MD5Util.generate(spitter.getPassword()));
        spitterDao.addSpitter(spitter);
    }

    //获取用户信息，展示于用户个人主页
    @Transactional
    public Spitter getByNickname(String nickname) {
        return spitterDao.getByNickname(nickname);
    }

    //根据用户名和密码，获取完整的用户信息
    @Transactional
    public Spitter getSpitter(Spitter spitter) {

        return spitterDao.getSpitter(spitter);
    }

    //将密码加盐计算MD5，验证密码正确性
    @Transactional
    public Spitter verifySpitter(Spitter spitter) {
        String password = spitterDao.getPassword(spitter.getUsername());

        //如果用户存在 且 密码正确，返回 包含完整信息的用户对象
        if(password != null && MD5Util.verify(spitter.getPassword(), password)){
            spitter.setPassword(password);
            return getSpitter(spitter);
        }

        return null;
    }

}
