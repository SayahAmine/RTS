package com.game.building;


import com.game.resource.ResourceType;

import java.util.Map;

public interface Building {

    Map<ResourceType, Integer> getCost();

    void produce(); // called each turn

    String getName();
}