package com.game.ui;

import com.game.game.Player;
import com.game.resource.ResourceType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerStatusPanel extends VBox {

    private final Player player;
    private final Label info = new Label();

    public PlayerStatusPanel(Player player) {
        this.player = player;

        setSpacing(10);
        setStyle("-fx-padding: 10; -fx-border-color: black;");

        getChildren().addAll(
                new Label("PLAYER STATUS"),
                info
        );

        refresh();
    }

    public void refresh() {
        info.setText(
                "Gold: " + player.getResources().get(ResourceType.GOLD) + "\n" +
                        "Wood: " + player.getResources().get(ResourceType.WOOD) + "\n" +
                        "Stone: " + player.getResources().get(ResourceType.STONE) + "\n" +
                        "Food: " + player.getResources().get(ResourceType.FOOD) + "\n\n" +
                        "Units: " + player.getUnits().size() + "\n" +
                        "Buildings: " + player.getBuildings().size()
        );
    }
}
