package com.game.app.ai;

import com.game.core.building.CommandCenter;
import com.game.core.building.Mine;
import com.game.core.resource.ResourceType;
import com.game.core.unit.Soldier;
import com.game.faction.Faction;

public class AIController {

    private final Faction faction;

    public AIController(Faction faction) {
        this.faction = faction;
    }


    public void takeTurn(){
        // building economy

        if(faction.getBuildings().isEmpty()){
            faction.getBuildings().add(new CommandCenter());
            faction.getBuildings().add(new Mine());
            System.out.println(faction.getName() + " built Command Center and Mine.");


        }

        //build army
        if(faction.getResources().Isenought(ResourceType.FOOD,5)){
            faction.getResources().consume(ResourceType.FOOD,5);
            faction.getUnits().add(new Soldier());
            System.out.println(faction.getName() + " trained a Soldier.");
        }



    }
}
