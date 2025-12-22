package com.game.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {


    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setCenter(new Label("Strategic Game Prototype"));

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Strategy Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
