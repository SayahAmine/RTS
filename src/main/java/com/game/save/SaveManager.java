package com.game.save;

import com.game.game.Game;
import java.io.*;

public class SaveManager {

    private static final String SAVE_FILE = "savegame.dat";

    public static void save(Game game) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {

            out.writeObject(game);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game load() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(SAVE_FILE))) {

            return (Game) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
