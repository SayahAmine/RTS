package com.game.faction;

import com.game.core.building.Building;
import com.game.core.resource.Resource;
import com.game.core.unit.AbstractUnit;

import java.util.ArrayList;
import java.util.List;

public class Faction {

    private final String name;
    private final Resource resources = new Resource();
    private final List<AbstractUnit> units = new ArrayList<>();
    private final List<Building> buildings = new ArrayList<>();

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Resource getResources() {
        return resources;
    }

    public List<AbstractUnit> getUnits() {
        return units;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void nextTurn() {
        for (Building b : buildings) {
            b.applyEffect(resources);
        }
    }
}
