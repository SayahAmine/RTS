package com.game.ui;

import com.game.map.MapGrid;
import com.game.map.Tile;
import com.game.unit.AbstractUnit;

public class TileClickHandler {

    private static AbstractUnit selected;
    private static MapGrid map;

    public static void init(MapGrid mapGrid) {
        map = mapGrid;
    }

    public static void selectUnit(AbstractUnit unit) {
        selected = unit;
    }

    public static void handle(int x, int y) {
        if (selected == null) return;

        Tile oldTile = map.getTile(selected.getX(), selected.getY());
        Tile newTile = map.getTile(x, y);

        oldTile.removeUnit(selected);
        newTile.addUnit(selected);

        selected.moveTo(x, y);
        selected = null;
    }
}
