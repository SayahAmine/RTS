package com.game.game;

import com.game.building.Building;
import com.game.building.CommandCenter;

public class VictoryChecker {

    public static boolean playerWins(Player player, Player enemy) {
        return enemy.getUnits().isEmpty() || !hasCommandCenter(enemy);
    }

    public static boolean playerLoses(Player player) {
        return player.getUnits().isEmpty() || !hasCommandCenter(player);
    }

    private static boolean hasCommandCenter(Player player) {
        for (Building b : player.getBuildings()) {
            if (b instanceof CommandCenter) {
                return true;
            }
        }
        return false;
    }
}
