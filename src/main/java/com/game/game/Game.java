package com.game.game;

import java.io.Serializable;

public class Game implements Serializable {

    private Player player;
    private Player enemy;

    public Game() {
        this.player = new Player();
        this.enemy = new Player(); // 👈 enemy faction
    }

    public Player getPlayer() {
        return player;
    }

    public Player getEnemy() {
        return enemy;
    }
}
