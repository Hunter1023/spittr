package com.hunter.spittr.Service;

import com.hunter.spittr.meta.Spitter;

public interface SpitterService {
    boolean isRegistered(Spitter spitter);

    Spitter getByUsername(String username);
}
