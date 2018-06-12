package com.hunter.spittr.service;

import com.hunter.spittr.meta.Spitter;

public interface SpitterService {
    boolean isRegistered(Spitter spitter);

    void register(Spitter spitter);

    Spitter getByNickname(String nickname);

    Spitter getSpitter(Spitter spitter);

    Spitter verifySpitter(Spitter spitter);

    void updateUserInfo(Spitter spitter);

}
