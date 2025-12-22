package com.game.building;


import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;

import java.util.Map;

public class CommandCenter extends AbstractBuilding {

    public CommandCenter(ResourcePool pool) {
        super(pool);
    }

    @Override
    public Map<ResourceType, Integer> getCost() {
        return Map.of(
                ResourceType.GOLD, 300,
                ResourceType.WOOD, 200
        );
    }

    @Override
    public void produce() {
        addResource(ResourceType.FOOD, 10);
    }

    @Override
    public String getName() {
        return "Command Center";
    }
}