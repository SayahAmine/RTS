package com.game.app.state;

import com.game.core.building.AbstractBuilding;
import com.game.core.building.Building;
import com.game.core.resource.Resource;
import com.game.core.unit.AbstractUnit;
import com.game.core.unit.AbstractUnit;
import com.game.faction.Faction;

import java.util.ArrayList;
import java.util.List;

public class GameStat {


    private final List<Faction> factions = new ArrayList<>();
    private int turnCounter = 0;

    public List<Faction> getFactions() {
        return factions;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void nextTurn() {
        turnCounter++;
        for (Faction f : factions) {
            f.nextTurn();
        }
    }
}
