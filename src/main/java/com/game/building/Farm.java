package com.game.building;

import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;

import java.util.Map;

public class Farm extends AbstractBuilding {

    public Farm(ResourcePool pool) {
        super(pool);
    }

    @Override
    public Map<ResourceType, Integer> getCost() {
        return Map.of(
                ResourceType.WOOD, 60,
                ResourceType.GOLD, 40
        );
    }

    @Override
    public void produce() {
        addResource(ResourceType.FOOD, 30);
    }

    @Override
    public String getName() {
        return "Farm";
    }
}
