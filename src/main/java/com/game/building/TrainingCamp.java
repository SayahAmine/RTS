package com.game.building;

import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;

import java.util.Map;

public class TrainingCamp extends AbstractBuilding {

    public TrainingCamp(ResourcePool pool) {
        super(pool);
    }

    @Override
    public Map<ResourceType, Integer> getCost() {
        return Map.of(
                ResourceType.GOLD, 150,
                ResourceType.WOOD, 100
        );
    }

    @Override
    public void produce() {
        // No passive production
    }

    @Override
    public String getName() {
        return "Training Camp";
    }
}