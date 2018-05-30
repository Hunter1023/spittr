package com.hunter.spittr.service;

import com.hunter.spittr.meta.Spitter;

public interface SpitterService {
    boolean isRegistered(Spitter spitter);

    void register(Spitter spitter);

    Spitter getByUsername(String username);

    Spitter getByUserId(Long userId);

    Spitter verifySpitter(Spitter spitter);
}
