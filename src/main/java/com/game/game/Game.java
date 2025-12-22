package com.game.game;

import com.game.ai.EnemyAI;
import com.game.building.Building;
import com.game.building.CommandCenter;
import com.game.building.Mine;
import com.game.map.MapGrid;
import com.game.resource.ResourcePool;
import com.game.resource.ResourceType;
import com.game.unit.AbstractUnit;
import com.game.unit.Soldier;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private Player enemy;
    private EnemyAI enemyAI;
    private GameTurnManager turnManager;

    public Game() {
        initGame();
    }

    private void initGame() {

        // Map
        MapGrid map = new MapGrid(10, 10);

        // Player
        player = new Player("PLAYER");
        player.getResources().add(ResourceType.GOLD, 300);
        player.getResources().add(ResourceType.WOOD, 200);

        player.getBuildings().add(new CommandCenter(player.getResources()));
        player.getBuildings().add(new Mine(player.getResources()));
        player.getUnits().add(new Soldier());

        // Enemy
        enemy = new Player("AI");
        enemy.getResources().add(ResourceType.GOLD, 300);
        enemy.getResources().add(ResourceType.WOOD, 200);

        enemy.getBuildings().add(new CommandCenter(enemy.getResources()));
        enemy.getUnits().add(new Soldier());

        // Enemy AI (NEW VERSION)
        enemyAI = new EnemyAI(enemy);

        // Turn manager
        turnManager = new GameTurnManager(player, enemyAI);
    }

    public void start() {
        while (true) {
            turnManager.nextTurn();

            if (VictoryChecker.playerWins(player, enemy)) {
                System.out.println("\n🎉 YOU WIN! Enemy defeated.");
                break;
            }

            if (VictoryChecker.playerLoses(player)) {
                System.out.println("\n💀 YOU LOSE! Your army is gone.");
                break;
            }
        }
    }
}