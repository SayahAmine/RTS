//package com.game.combat;
//
//
//import com.game.map.Tile;
//import com.game.unit.AbstractUnit;
//
//import java.util.Random;
//
//public class CombatResolver {
//
//    private static final Random random = new Random();
//
//    public static void resolveCombat(AbstractUnit attacker,
//                                     AbstractUnit defender,
//                                     Tile tile,
//                                     int distance) {
//
//        // Check range
//        if (distance > attacker.getRange()) {
//            System.out.println("Target out of range!");
//            return;
//        }
//
//        int baseDamage = attacker.getAttack();
//        int defense = defender.getDefense() + tile.getDefenseBonus();
//
//        // Cavalry charge bonus
//        if (attacker.getType().equals("CAVALRY") && distance == 1) {
//            baseDamage += 10;
//        }
//
//        // Controlled randomness (±10%)
//        int variance = (int)(baseDamage * 0.1);
//        baseDamage += random.nextInt(variance * 2 + 1) - variance;
//
//        int finalDamage = Math.max(0, baseDamage - defense);
//        defender.takeDamage(finalDamage);
//
//        System.out.println("Damage dealt: " + finalDamage);
//    }
//}