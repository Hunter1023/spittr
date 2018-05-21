package com.hunter.spittr.service;

import com.hunter.spittr.meta.Spitter;

public interface SpitterService {
    boolean isRegistered(Spitter spitter);

    Spitter getByUsername(String username);
}
