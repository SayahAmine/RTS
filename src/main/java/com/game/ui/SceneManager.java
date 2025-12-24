package com.game.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage primaryStage;

    public static void init(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Strategy Game");
    }

    public static void showMainMenu() {
        Scene scene = new Scene(new MainMenuView(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showGame() {
        Scene scene = new Scene(new GameView(), 1000, 700);
        primaryStage.setScene(scene);
    }
}
