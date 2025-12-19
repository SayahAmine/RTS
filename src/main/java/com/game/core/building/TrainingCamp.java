package com.game.core.building;

import com.game.core.resource.Resource;
import com.game.core.resource.ResourceType;

public class TrainingCamp extends AbstractBuilding {

    public TrainingCamp() {
        super("Training Camp",150,2);
    }

    @Override
    public void applyEffect(Resource resources) {
        if(resources.Isenought(ResourceType.FOOD,5)){
            resources.consume(ResourceType.FOOD,5);
            System.out.println("New soilder has been trained");
        }
    }
}
