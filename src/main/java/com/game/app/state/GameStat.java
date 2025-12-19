package com.game.app.state;

import com.game.core.building.AbstractBuilding;
import com.game.core.building.Building;
import com.game.core.resource.Resource;
import com.game.core.unit.AbstractUnit;
import com.game.core.unit.AbstractUnit;

import java.util.ArrayList;
import java.util.List;

public class GameStat {


    private final List<AbstractUnit> units = new ArrayList<>();
    private final List<AbstractBuilding> buildings = new ArrayList<>();
    private final Resource resource = new Resource();
    private int turnCounter = 0;

    public List<AbstractUnit> getUnits() {
        return units;
    }

    public List<AbstractBuilding> getBuildings() {
        return buildings;
    }

    public Resource getResource() {
        return resource;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void nextTurn() {
        turnCounter++;
        for (Building b :buildings){
            b.applyEffect(resource);
        }
    }
}
