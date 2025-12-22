package com.game.building;

import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;

import java.util.Map;

public class Sawmill extends AbstractBuilding {

    public Sawmill(ResourcePool pool) {
        super(pool);
    }

    @Override
    public Map<ResourceType, Integer> getCost() {
        return Map.of(
                ResourceType.GOLD, 80,
                ResourceType.WOOD, 30
        );
    }

    @Override
    public void produce() {
        addResource(ResourceType.WOOD, 25);
    }

    @Override
    public String getName() {
        return "Sawmill";
    }
}