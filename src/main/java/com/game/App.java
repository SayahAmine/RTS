package com.game;

import com.game.app.loop.TurnManager;
import com.game.app.state.GameStat;
import com.game.core.building.CommandCenter;
import com.game.core.building.Mine;
import com.game.core.unit.Soldier;
import com.game.faction.Faction;

public class App {
    public static void main(String[] args) {

        GameStat gs = new GameStat();

        Faction red = new Faction("Red");
        Faction blue = new Faction("Blue");


        // Add units
        red.getUnits().add(new Soldier());
        blue.getUnits().add(new Soldier());

        // Add buildings
        red.getBuildings().add(new CommandCenter());
        red.getBuildings().add(new Mine());

        gs.getFactions().add(red);
        gs.getFactions().add(blue);

        TurnManager tm = new TurnManager(gs);

        for (int i = 0; i < 5; i++) {
            tm.nextTurn();
            System.out.println("Turn " + gs.getTurnCounter());
            System.out.println(red.getName() + " resources: " + red.getResources().snapshot());
            System.out.println(blue.getName() + " resources: " + blue.getResources().snapshot());
        }

        System.out.println("Red units alive: " + red.getUnits().size());
        System.out.println("Blue units alive: " + blue.getUnits().size());

    }
}
