package com.game.unit;

public class Soldier extends AbstractUnit {

    public Soldier() {
        this.health = 80;
        this.attack = 20;
        this.defense = 8;
        this.range = 1;           // melee
        this.movementPoints = 3;
    }


    @Override
    public String getType() {
        return "Soldier";
    }
}
