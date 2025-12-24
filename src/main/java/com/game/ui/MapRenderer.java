package com.game.ui;

import com.game.map.MapGrid;
import com.game.map.Tile;
import com.game.unit.AbstractUnit;
import com.game.building.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapRenderer {

    private static final int SIZE = 50;

    public static GridPane render(MapGrid map) {
        GridPane grid = new GridPane();

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {

                Tile tile = map.getTile(x, y);

                Rectangle base = new Rectangle(SIZE, SIZE);
                base.setFill(terrainColor(tile));
                base.setStroke(Color.BLACK);

                StackPane cell = new StackPane(base);

                if (tile.getBuilding() != null) {
                    cell.getChildren().add(buildingIcon(tile.getBuilding()));
                }

                for (AbstractUnit u : tile.getUnits()) {
                    cell.getChildren().add(unitIcon(u));
                }

                int tx = x, ty = y;
                cell.setOnMouseClicked(e ->
                        TileClickHandler.handle(tx, ty)
                );

                grid.add(cell, x, y);
            }
        }
        return grid;
    }

    /* ---------- Helpers ---------- */

    private static Color terrainColor(Tile t) {
        return switch (t.getTerrain()) {
            case FOREST -> Color.web("#6BA368");
            case WATER -> Color.web("#5DADE2");
            case MOUNTAIN -> Color.web("#AAB7B8");
            default -> Color.web("#F9E79F");
        };
    }

    private static Label buildingIcon(Building b) {
        Label l = new Label(
                b instanceof Mine ? "⛏" :
                        b instanceof Farm ? "🌾" : "🪵"
        );
        l.setStyle("-fx-font-size:18px;");
        return l;
    }

    private static Label unitIcon(AbstractUnit u) {
        Label l = new Label(
                u.getType().equals("INFANTRY") ? "🪖" :
                        u.getType().equals("ARCHER") ? "🏹" : "🐎"
        );
        l.setStyle("-fx-font-size:16px;");
        return l;
    }
}
