package com.game.ui;

import com.game.building.Mine;
import com.game.game.Player;
import com.game.unit.Soldier;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ActionPanel extends VBox {

    public ActionPanel(Player player, EventLog log) {

        Button buildMine = new Button("Build Mine");
        Button trainSoldier = new Button("Train Soldier");

        buildMine.setOnAction(e -> {
            Mine mine = new Mine(player.getResources());
            if (player.getResources().spendCost(mine.getCost())) {
                player.getBuildings().add(mine);
                log.log("Built a Mine");
            } else {
                log.log("Not enough resources for Mine");
            }
        });

        trainSoldier.setOnAction(e -> {
            player.getUnits().add(new Soldier());
            log.log("Trained a Soldier");
        });

        setSpacing(12);
        setStyle("-fx-padding: 10; -fx-border-color: black;");
        getChildren().addAll(buildMine, trainSoldier);
    }
}
