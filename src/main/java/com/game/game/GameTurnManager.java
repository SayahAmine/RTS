package com.game.game;

import com.game.ai.EnemyAI;
import com.game.building.Building;
import com.game.resource.ResourceType;
import com.game.unit.AbstractUnit;

public class GameTurnManager {

    private Player player;
    private EnemyAI enemyAI;
    private PlayerController controller;

    public GameTurnManager(Player player, EnemyAI enemyAI) {
        this.player = player;
        this.enemyAI = enemyAI;
        this.controller = new PlayerController(player);
    }

    public void nextTurn() {
        System.out.println("\n====================");
        System.out.println("NEW TURN");
        System.out.println("====================");

        // 1. Production
        for (Building b : player.getBuildings()) {
            b.produce();
        }

        // 2. Player plays
        controller.playerTurn();

        // 3. AI plays
        System.out.println("\n--- AI TURN ---");
        enemyAI.playTurn();
    }
}