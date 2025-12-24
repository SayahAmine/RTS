package com.game.map;


import java.util.Random;

public class MapGrid {

    private Tile[][] grid;
    private int width;
    private int height;

    public MapGrid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Tile[width][height];
        generateRandomMap(); // 🔥 IMPORTANT
    }

    private void generateRandomMap() {
        Random random = new Random();
        TerrainType[] terrains = TerrainType.values();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                TerrainType terrain = terrains[random.nextInt(terrains.length)];
                grid[x][y] = new Tile(terrain); // ✅ NO NULLS
            }
        }
    }

    public Tile getTile(int x, int y) {
        return grid[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}