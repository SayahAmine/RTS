package com.game.building;


import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;

public abstract class AbstractBuilding implements Building {

    protected ResourcePool resourcePool;

    public AbstractBuilding(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;
    }

    protected void addResource(ResourceType type, int amount) {
        resourcePool.add(type, amount);
    }
}