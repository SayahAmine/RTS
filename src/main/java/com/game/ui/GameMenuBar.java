package com.game.ui;

import com.game.game.Game;
import com.game.save.SaveManager;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class GameMenuBar extends MenuBar {

    public GameMenuBar(Game game) {

        Menu gameMenu = new Menu("Game");

        MenuItem save = new MenuItem("Save Game");
        MenuItem back = new MenuItem("Back to Main Menu");
        MenuItem exit = new MenuItem("Exit");

        save.setOnAction(e -> SaveManager.save(game));
        back.setOnAction(e -> SceneManager.showMainMenu());
        exit.setOnAction(e -> System.exit(0));

        gameMenu.getItems().addAll(save, back, exit);
        getMenus().add(gameMenu);
    }
}
