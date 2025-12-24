package com.game.ui;

import com.game.unit.AbstractUnit;

public class TileClickHandler {

    private static AbstractUnit selectedUnit;
    private static int selectedX;
    private static int selectedY;

    /**
     * Called when the player clicks on a unit
     */
    public static void selectUnit(AbstractUnit unit, int x, int y) {
        selectedUnit = unit;
        selectedX = x;
        selectedY = y;
        System.out.println("Unit selected at (" + x + ", " + y + ")");
    }

    /**
     * Called when the player clicks on a tile
     */
    public static void handle(int targetX, int targetY) {

        if (selectedUnit == null) {
            System.out.println("No unit selected");
            return;
        }

        // Simple movement (no pathfinding yet)
        selectedUnit.moveTo(targetX, targetY);

        System.out.println(
                "Unit moved from (" + selectedX + "," + selectedY +
                        ") to (" + targetX + "," + targetY + ")"
        );

        // Clear selection after move
        selectedUnit = null;
    }
}
