package com.game.ui;

import com.game.ai.EnemyAI;
import com.game.game.Game;
import com.game.map.MapGrid;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {

    public GameView(Game game) {

        EventLog eventLog = new EventLog(); // 👈 ONE instance

        EnemyAI enemyAI = new EnemyAI(game.getEnemy(), eventLog);

        Runnable endTurnAction = () -> enemyAI.playTurn();

        setTop(new GameMenuBar(game));
        setCenter(MapRenderer.render(new MapGrid(10, 10)));
        setLeft(new PlayerStatusPanel(game.getPlayer()));
        setRight(new ActionPanel(game.getPlayer(), eventLog, endTurnAction));
        setBottom(eventLog);
    }
}
