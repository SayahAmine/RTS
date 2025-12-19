package com.game.core.building;

import com.game.core.resource.Resource;
import com.game.core.resource.ResourceType;

public class Sawmill extends AbstractBuilding{

    public Sawmill(){
        super("Sawmill",100,2);
    }

    @Override
    public void applyEffect(Resource resources) {
        resources.addResource(ResourceType.FOOD,15);
    }
}
