package com.game.ui;

import com.game.game.Game;
import com.game.save.SaveManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuView extends VBox {

    public MainMenuView() {

        Label title = new Label("STRATEGY GAME");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Button newGame = new Button("New Game");
        Button loadGame = new Button("Load Game");
        Button quit = new Button("Quit");

        newGame.setPrefWidth(200);
        loadGame.setPrefWidth(200);
        quit.setPrefWidth(200);

        newGame.setOnAction(e ->
                SceneManager.showLoadedGame(new Game())
        );


        loadGame.setOnAction(e -> {
            System.out.println("Load Game clicked (not implemented yet)");
        });

        quit.setOnAction(e -> System.exit(0));

        setAlignment(Pos.CENTER);
        setSpacing(20);

        getChildren().addAll(title, newGame, loadGame, quit);

        loadGame.setOnAction(e -> {
            Game loaded = SaveManager.load();
            if (loaded != null) {
                SceneManager.showLoadedGame(loaded);
            }
        });

    }
}
