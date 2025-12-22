package com.game.game;

import com.game.building.*;
import com.game.resource.ResourceType;
import com.game.unit.AbstractUnit;
import com.game.unit.Archer;
import com.game.unit.Cavalier;
import com.game.unit.Soldier;

import java.util.Scanner;

public class PlayerController {

    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public PlayerController(Player player) {
        this.player = player;
    }

    public void playerTurn() {
        boolean endTurn = false;

        while (!endTurn) {
            System.out.println("\n--- PLAYER TURN ---");
            System.out.println("1. Build");
            System.out.println("2. Train Unit");
            System.out.println("3. Show Resources");
            System.out.println("4. End Turn");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> buildMenu();
                case 2 -> trainMenu();
                case 3 -> showResources();
                case 4 -> endTurn = true;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void buildMenu() {
        System.out.println("Build:");
        System.out.println("1. Mine");
        System.out.println("2. Sawmill");
        System.out.println("3. Farm");
        System.out.println("4. Quarry");

        int choice = scanner.nextInt();
        Building b = null;

        switch (choice) {
            case 1 -> b = new Mine(player.getResources());
            case 2 -> b = new Sawmill(player.getResources());
            case 3 -> b = new Farm(player.getResources());
            case 4 -> b = new Quarry(player.getResources());
        }

        if (b != null && player.getResources().spendCost(b.getCost())) {
            player.getBuildings().add(b);
            System.out.println(b.getName() + " built!");
        } else {
            System.out.println("Not enough resources.");
        }
    }

    private void trainMenu() {
        System.out.println("Train:");
        System.out.println("1. Soldier");
        System.out.println("2. Archer");
        System.out.println("3. Cavalry");

        int choice = scanner.nextInt();
        AbstractUnit unit = null;

        switch (choice) {
            case 1 -> unit = new Soldier();
            case 2 -> unit = new Archer();
            case 3 -> unit = new Cavalier();
        }

        if (unit != null) {
            player.getUnits().add(unit);
            System.out.println(unit.getType() + " trained!");
        }
    }

    private void showResources() {
        System.out.println("GOLD: " + player.getResources().get(ResourceType.GOLD));
        System.out.println("WOOD: " + player.getResources().get(ResourceType.WOOD));
        System.out.println("STONE: " + player.getResources().get(ResourceType.STONE));
        System.out.println("FOOD: " + player.getResources().get(ResourceType.FOOD));
    }
}