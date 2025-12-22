package com.game.unit;

public class Cavalier extends AbstractUnit {

    public Cavalier() {
        this.health = 100;
        this.attack = 25;
        this.defense = 10;
        this.range = 1;
        this.movementPoints = 4;
    }


    @Override
    public String getType() {
        return "Cavalier ";
    }
}
