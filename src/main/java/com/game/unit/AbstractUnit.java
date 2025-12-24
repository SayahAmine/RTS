package com.game.unit;

import java.io.Serializable;

public abstract class AbstractUnit implements Serializable {

    protected int health;
    protected int attack;
    protected int defense;
    protected int movementPoints;
    protected int range;

    // ✅ position on map
    protected int x;
    protected int y;

    /* ================== STATE ================== */

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= Math.max(0, damage - defense);
        if (health < 0) health = 0;
    }

    /* ================== MOVEMENT ================== */

    public void moveTo(int targetX, int targetY) {
        this.x = targetX;
        this.y = targetY;
    }

    /* ================== GETTERS ================== */

    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getRange() { return range; }
    public int getMovementPoints() { return movementPoints; }

    public int getX() { return x; }
    public int getY() { return y; }

    public abstract String getType();
}
