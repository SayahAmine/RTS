package com.game.core.building;

import com.game.core.resource.Resource;
import com.game.core.resource.ResourceType;

public class Mine extends AbstractBuilding {

    public Mine() {
        super("Mine",100,2);
    }

    @Override
    public void applyEffect(Resource resources) {
        resources.addResource(ResourceType.STONE,15);
    }
}
