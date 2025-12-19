package com.game.core.unit;

public abstract class AbstractUnit {

    protected int hp,attack,defense,range,cost;

    public boolean IsAlive() {
        return hp > 0;
    }

    public void takeDamage( int damage ) {
        hp -= damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }
}
