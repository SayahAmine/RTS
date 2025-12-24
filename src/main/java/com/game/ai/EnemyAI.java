package com.game.ai;

import com.game.building.*;
import com.game.game.Player;
import com.game.resource.ResourceType;
import com.game.unit.*;
import com.game.ui.EventLog;

import java.util.Random;

public class EnemyAI {

    private final Player enemy;
    private final EventLog log;
    private AIStrategyType strategy;
    private final Random random = new Random();

    public EnemyAI(Player enemy, EventLog log) {
        this.enemy = enemy;
        this.log = log;
        this.strategy = pickRandomStrategy();
    }

    /* ===================== TURN ===================== */

    public void playTurn() {
        log.log("Enemy strategy: " + strategy);

        switch (strategy) {
            case ECONOMIC -> economyTurn();
            case AGGRESSIVE -> aggressiveTurn();
            case BALANCED -> balancedTurn();
        }

        produceResources();

        if (random.nextInt(5) == 0) {
            strategy = pickRandomStrategy();
            log.log("Enemy changed strategy");
        }

        log.log("Enemy turn ended");
    }

    /* ===================== STRATEGIES ===================== */

    private void economyTurn() {
        if (tryBuild(new Farm(enemy.getResources()), "Farm")) return;
        if (tryBuild(new Sawmill(enemy.getResources()), "Sawmill")) return;
        if (tryBuild(new Mine(enemy.getResources()), "Mine")) return;
        trainRandomUnit();
    }

    private void aggressiveTurn() {
        if (enemy.getUnits().size() < 5) {
            trainRandomUnit();
        } else {
            log.log("Enemy is preparing an attack");
        }
    }

    private void balancedTurn() {
        if (enemy.getUnits().size() < 3) {
            trainRandomUnit();
        } else if (random.nextBoolean()) {
            trainRandomUnit();
        } else {
            tryBuild(new Mine(enemy.getResources()), "Mine");
        }
    }

    /* ===================== ACTIONS ===================== */

    private boolean tryBuild(Building building, String name) {
        if (enemy.getResources().spendCost(building.getCost())) {
            enemy.getBuildings().add(building);
            log.log("Enemy built a " + name);
            return true;
        }
        return false;
    }

    private void trainRandomUnit() {
        AbstractUnit unit = switch (random.nextInt(3)) {
            case 0 -> new Soldier();
            case 1 -> new Archer();
            default -> new Cavalier();
        };
        enemy.getUnits().add(unit);
        log.log("Enemy trained " + unit.getType());
    }

    /* ===================== ECONOMY ===================== */

    private void produceResources() {
        for (Building b : enemy.getBuildings()) {
            if (b instanceof Farm)
                enemy.getResources().add(ResourceType.FOOD, 20);
            if (b instanceof Mine)
                enemy.getResources().add(ResourceType.STONE, 15);
            if (b instanceof Sawmill)
                enemy.getResources().add(ResourceType.WOOD, 15);
        }
    }

    /* ===================== UTILS ===================== */

    private AIStrategyType pickRandomStrategy() {
        return AIStrategyType.values()
                [random.nextInt(AIStrategyType.values().length)];
    }
}
