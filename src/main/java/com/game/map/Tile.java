package com.game.map;


import com.game.unit.AbstractUnit;

public class Tile {

   private TerrainType terrain;
   private String controllingFaction;

    public Tile(TerrainType terrain) {
        this.terrain = terrain;
        this.controllingFaction = null;
    }

    public TerrainType getTerrain() {
        return terrain;
    }

    public String getControllingFaction() {
        return controllingFaction;
    }

    public void setControllingFaction(String controllingFaction) {
        this.controllingFaction = controllingFaction;
    }

    public boolean canEnter(AbstractUnit unit){
        switch (terrain){
            case MOUNTAIN ->
            {
                return !unit.getType().equals("CAVALRY");
            }
            case WATER ->
                {
                return !unit.getType().equals("INFANTRY");
            }
            default ->
                {
                return true;
                }
        }
    }

    public int getDefenseBonus() {
        if (terrain == TerrainType.FOREST) return 2;
        return 0;
    }

    public int getSpeedModifier() {
        if (terrain == TerrainType.PLAIN) return 1;
        return 0;
    }
}
