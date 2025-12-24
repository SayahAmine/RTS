package com.game.ui;

import com.game.map.MapGrid;
import com.game.map.Tile;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapRenderer {

    private static final int TILE_SIZE = 50;

    public static GridPane render(MapGrid map) {
        GridPane grid = new GridPane();

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {

                Tile tile = map.getTile(x, y);

                Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE);
                rect.setStroke(Color.BLACK);
                rect.setFill(getColor(tile));

                StackPane tilePane = new StackPane(rect);

                int tx = x;
                int ty = y;

                tilePane.setOnMouseClicked(e ->
                        TileClickHandler.handle(tx, ty)
                );

                grid.add(tilePane, x, y);
            }
        }
        return grid;
    }

    private static Color getColor(Tile tile) {
        return switch (tile.getTerrain()) {
            case FOREST -> Color.DARKGREEN;
            case WATER -> Color.DEEPSKYBLUE;
            case MOUNTAIN -> Color.GRAY;
            default -> Color.BEIGE;
        };
    }
}
