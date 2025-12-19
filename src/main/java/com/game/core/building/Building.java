package com.game.core.building;

import com.game.core.resource.Resource;

public interface Building {

    int getCost();
    int getConstractionTime();
    void applyEffect(Resource resources);
    String getName();
}
