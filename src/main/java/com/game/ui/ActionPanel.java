package com.game.ui;

import com.game.building.*;
import com.game.game.Player;
import com.game.unit.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import static com.sun.glass.ui.MenuItem.Separator;

public class ActionPanel extends VBox {

    private final Player player;
    private final EventLog log;
    private final Runnable onEndTurn;

    public ActionPanel(Player player, EventLog log, Runnable onEndTurn) {
        this.player = player;
        this.log = log;
        this.onEndTurn = onEndTurn;

        setSpacing(12);
        setStyle("-fx-padding:10; -fx-border-color:black;");

        getChildren().addAll(
                buildSection(),
                new Separator(),
                unitSection(),
                new Separator(),
                endTurnSection()
        );
    }

    /* ===================== BUILDINGS ===================== */

    private VBox buildSection() {
        VBox box = new VBox(8);

        Label title = new Label("🏗️ Buildings");
        title.setStyle("-fx-font-weight: bold;");

        Button mineBtn = new Button("Build Mine");
        Button farmBtn = new Button("Build Farm");
        Button sawmillBtn = new Button("Build Sawmill");

        mineBtn.setOnAction(e -> build(new Mine(player.getResources()), "Mine"));
        farmBtn.setOnAction(e -> build(new Farm(player.getResources()), "Farm"));
        sawmillBtn.setOnAction(e -> build(new Sawmill(player.getResources()), "Sawmill"));

        box.getChildren().addAll(title, mineBtn, farmBtn, sawmillBtn);
        return box;
    }

    private void build(Building building, String name) {
        if (player.getResources().spendCost(building.getCost())) {
            player.getBuildings().add(building);
            log.log(name + " constructed");
        } else {
            log.log("Not enough resources for " + name);
        }
    }

    /* ===================== UNITS ===================== */

    private VBox unitSection() {
        VBox box = new VBox(8);

        Label title = new Label("🪖 Units");
        title.setStyle("-fx-font-weight: bold;");

        Button soldierBtn = new Button("Train Soldier");
        Button archerBtn = new Button("Train Archer");
        Button cavalryBtn = new Button("Train Cavalry");

        soldierBtn.setOnAction(e -> train(new Soldier(), "Soldier"));
        archerBtn.setOnAction(e -> train(new Archer(), "Archer"));
        cavalryBtn.setOnAction(e -> train(new Cavalier(), "Cavalry"));

        box.getChildren().addAll(title, soldierBtn, archerBtn, cavalryBtn);
        return box;
    }

    private void train(AbstractUnit unit, String name) {
        player.getUnits().add(unit);
        log.log(name + " trained");
    }

    /* ===================== END TURN ===================== */

    private VBox endTurnSection() {
        VBox box = new VBox(8);

        Button endTurnBtn = new Button("⏭ End Turn");
        endTurnBtn.setStyle("-fx-font-weight: bold; -fx-background-color: lightgray;");

        endTurnBtn.setOnAction(e -> {
            log.log("Player ended their turn");
            onEndTurn.run();   // 🔥 notify game / AI
        });

        box.getChildren().add(endTurnBtn);
        return box;
    }
}
