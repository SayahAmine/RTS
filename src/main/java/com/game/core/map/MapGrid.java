package com.game.core.map;

import java.util.ArrayList;
import java.util.List;

public class MapGrid {

    private final int width;
    private final int height;
    private final List<Tile> tiles;

    public MapGrid( int width, int height )
    {
        this.width = width;
        this.height = height;
        this.tiles = new ArrayList<Tile>();
    }

    public void addTile( Tile tile )
    {
        this.tiles.add( tile );
    }

    public Tile getTiles(int x, int y) {
        return tiles.get(y*width+x);
    }
}
