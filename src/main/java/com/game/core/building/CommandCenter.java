package com.game.core.building;

import com.game.core.resource.Resource;
import com.game.core.resource.ResourceType;

public class CommandCenter extends AbstractBuilding {

    public CommandCenter() {
        super("Command Center",200,3);
    }


    @Override
    public void applyEffect(Resource resources) {
        resources.addResource(ResourceType.GOLD,10);
    }

}
