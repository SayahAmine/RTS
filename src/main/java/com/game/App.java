package com.game;

import com.game.app.loop.TurnManager;
import com.game.app.state.GameStat;
import com.game.core.building.CommandCenter;
import com.game.core.building.Mine;
import com.game.core.unit.Soldier;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        GameStat gs = new GameStat();


        // Add units
        gs.getUnits().add(new Soldier());
        gs.getUnits().add(new Soldier());

        // Add buildings
        gs.getBuildings().add(new CommandCenter());
        gs.getBuildings().add(new Mine());

        TurnManager tm = new TurnManager(gs);

        for (int i = 0; i < 5; i++) {
            tm.nextTurn();
            System.out.println("Turn " + gs.getTurnCounter() + " resources: " + gs.getResource().snapshot());
        }

        System.out.println("Units alive: " + gs.getUnits().size());
    }

}
