package com.game.building;

import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;

import java.util.Map;

public class Quarry extends AbstractBuilding {

    public Quarry(ResourcePool pool) {
        super(pool);
    }

    @Override
    public Map<ResourceType, Integer> getCost() {
        return Map.of(
                ResourceType.GOLD, 120,
                ResourceType.WOOD, 50
        );
    }

    @Override
    public void produce() {
        addResource(ResourceType.STONE, 20);
    }

    @Override
    public String getName() {
        return "Quarry";
    }
}