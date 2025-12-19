package com.game.core.map;

public class Tile {

    private final String Type;
    private final boolean accessible;
    private final int bouse;
    private final int penalty;

    public Tile(String type, boolean accessible, int bouse, int penalty) {
        Type = type;
        this.accessible = accessible;
        this.bouse = bouse;
        this.penalty = penalty;
    }

    public String getType() {
        return Type;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public int getPenalty() {
        return penalty;
    }

    public int getBouse() {
        return bouse;
    }
}
