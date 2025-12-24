package com.game.map;

import com.game.unit.AbstractUnit;
import com.game.building.Building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tile implements Serializable {

    private TerrainType terrain;
    private Building building;
    private List<AbstractUnit> units = new ArrayList<>();

    public Tile(TerrainType terrain) {
        this.terrain = terrain;
    }

    public TerrainType getTerrain() {
        return terrain;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<AbstractUnit> getUnits() {
        return units;
    }

    public void addUnit(AbstractUnit unit) {
        units.add(unit);
        unit.moveTo(0, 0); // optional init
    }

    public void removeUnit(AbstractUnit unit) {
        units.remove(unit);
    }
}
