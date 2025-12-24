package com.game.game;

import com.game.building.Building;
import com.game.resource.ResourcePool;
import com.game.unit.AbstractUnit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private ResourcePool resources;
    private List<AbstractUnit> units;
    private List<Building> buildings;

    public Player() {
        resources = new ResourcePool();
        units = new ArrayList<>();
        buildings = new ArrayList<>();
    }

    public ResourcePool getResources() {
        return resources;
    }

    public List<AbstractUnit> getUnits() {
        return units;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
