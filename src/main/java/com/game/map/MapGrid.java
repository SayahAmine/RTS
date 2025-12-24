package com.game.map;

import java.io.Serializable;
import java.util.Random;

public class MapGrid implements Serializable {

    private final int width;
    private final int height;
    private final Tile[][] tiles;

    public MapGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        generate();
    }

    private void generate() {
        Random r = new Random();
        TerrainType[] terrains = TerrainType.values();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile(
                        terrains[r.nextInt(terrains.length)]
                );
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
