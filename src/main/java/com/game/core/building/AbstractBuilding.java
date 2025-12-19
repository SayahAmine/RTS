package com.game.core.building;

public abstract class AbstractBuilding implements Building {

    protected final String name;
    protected final int cost;
    protected final int constractionTime;

    public AbstractBuilding(String name, int cost, int constractionTime) {
        this.name = name;
        this.cost = cost;
        this.constractionTime = constractionTime;
    }

    @Override
    public int getCost(){
        return cost;
    }

    @Override
    public int getConstractionTime(){
        return constractionTime;
    }

    @Override
    public String getName() {
        return name;
    }
}
