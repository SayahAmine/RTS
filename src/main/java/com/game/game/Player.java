package com.game.game;

import com.game.building.Building;
import com.game.resource.ResourcePool;
import com.game.unit.AbstractUnit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private ResourcePool resources;
    private List<Building> buildings;
    private List<AbstractUnit> units;

    public Player(String name) {
        this.name = name;
        this.resources = new ResourcePool();
        this.buildings = new ArrayList<>();
        this.units = new ArrayList<>();
    }

    public String getName() { return name; }
    public ResourcePool getResources() { return resources; }
    public List<Building> getBuildings() { return buildings; }
    public List<AbstractUnit> getUnits() { return units; }
}