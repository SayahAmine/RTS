package com.game.ui;

import com.game.game.Game;
import com.game.map.MapGrid;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {

    private Game game;

    public GameView() {
        this.game = new Game();

        // Map
        MapGrid map = new MapGrid(10, 10);
        setCenter(MapRenderer.render(map));

        // Player status
        PlayerStatusPanel statusPanel =
                new PlayerStatusPanel(game.getPlayer());
        setLeft(statusPanel);

        // Event log
        EventLog eventLog = new EventLog();
        setBottom(eventLog);

        // Action buttons
        ActionPanel actions =
                new ActionPanel(game.getPlayer(), eventLog);
        setRight(actions);
    }
}
