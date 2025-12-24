package com.game.building;


import com.game.resource.ResourceType;

import java.io.Serializable;
import java.util.Map;

public interface Building extends Serializable {

    Map<ResourceType, Integer> getCost();

    void produce(); // called each turn

    String getName();
}