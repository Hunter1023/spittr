package com.hunter.spittr.service;

import com.hunter.spittr.meta.Spitter;

public interface SpitterService {
    boolean isRegistered(Spitter spitter);

    void register(Spitter spitter);

    Spitter getByNickname(String nickname);

    Spitter verifySpitter(Spitter spitter);

    public Spitter encryptPassword(Spitter spitter);
}
