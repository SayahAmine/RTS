package com.game.ui;

import com.game.game.Game;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage primaryStage;

    public static void init(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Strategy Game");
    }

    public static void showMainMenu() {
        primaryStage.setScene(new Scene(new MainMenuView(), 800, 600));
        primaryStage.show();
    }

    // ✅ ADD THIS METHOD
    public static void showLoadedGame(Game game) {
        primaryStage.setScene(new Scene(new GameView(game), 1000, 700));
    }
}
