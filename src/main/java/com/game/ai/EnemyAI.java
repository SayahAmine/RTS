package com.game.ai;



import com.game.building.Building;
import com.game.building.Farm;
import com.game.building.Mine;
import com.game.building.Sawmill;
import com.game.game.Player;
import com.game.map.MapGrid;
import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;
import com.game.unit.AbstractUnit;
import com.game.unit.Archer;
import com.game.unit.Cavalier;
import com.game.unit.Soldier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import java.util.Random;



/**
 * Enemy AI controller
 * Uses simple rule-based strategies to act each turn
 */
public class EnemyAI {

    private Player enemy;
    private AIStrategyType strategy;
    private Random random;

    public EnemyAI(Player enemy) {
        this.enemy = enemy;
        this.random = new Random();
        this.strategy = pickRandomStrategy();
    }


    /**
     * Called once per turn
     */
    public void playTurn() {
        System.out.println("AI Strategy: " + strategy);

        switch (strategy) {
            case ECONOMIC -> economyTurn();
            case AGGRESSIVE -> aggressiveTurn();
            case BALANCED -> balancedTurn();
        }

        // Occasionally change strategy (keeps AI fresh)
        if (random.nextInt(5) == 0) {
            strategy = pickRandomStrategy();
            System.out.println("AI changes strategy to: " + strategy);
        }
    }

    /* ===================== STRATEGIES ===================== */

    // Focus on buildings & resources
    private void economyTurn() {
        if (tryBuild(new Farm(enemy.getResources()))) return;
        if (tryBuild(new Sawmill(enemy.getResources()))) return;
        if (tryBuild(new Mine(enemy.getResources()))) return;

        trainRandomUnit();
    }

    // Focus on army size
    private void aggressiveTurn() {
        if (enemy.getUnits().size() < 5) {
            trainRandomUnit();
        } else {
            System.out.println("AI prepares an attack!");
            // later: movement + combat
        }
    }

    // Mix of economy + army
    private void balancedTurn() {
        if (enemy.getUnits().size() < 3) {
            trainRandomUnit();
        } else if (random.nextBoolean()) {
            trainRandomUnit();
        } else {
            tryBuild(new Mine(enemy.getResources()));
        }
    }

    /* ===================== ACTIONS ===================== */

    private boolean tryBuild(Building building) {
        if (enemy.getResources().spendCost(building.getCost())) {
            enemy.getBuildings().add(building);
            System.out.println("AI builds: " + building.getName());
            return true;
        }
        return false;
    }

    private void trainRandomUnit() {
        AbstractUnit unit;

        int choice = random.nextInt(3);
        switch (choice) {
            case 0 -> unit = new Soldier();
            case 1 -> unit = new Archer();
            default -> unit = new Cavalier();
        }

        enemy.getUnits().add(unit);
        System.out.println("AI trains: " + unit.getType());
    }

    /* ===================== HELPERS ===================== */

    private AIStrategyType pickRandomStrategy() {
        return AIStrategyType.values()[random.nextInt(AIStrategyType.values().length)];
    }
}
