package com.game.unit;

public class Archer extends AbstractUnit {

    public Archer() {
        this.health = 60;
        this.attack = 15;
        this.defense = 5;
        this.range = 3;
        this.movementPoints = 2;
    }

    @Override
    public String getType() {
        return "ARCHER";
    }
}



