package com.game.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.init(stage);
        SceneManager.showMainMenu();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
