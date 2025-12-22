package com.game.unit;

public abstract class AbstractUnit {

    protected int health;
    protected int attack;
    protected int defense;
    protected int movementPoints;
    protected int range;


    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public abstract String getType();

    // Getters
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getRange() { return range; }
    public int getMovementPoints() { return movementPoints; }
}
