package com.game.core.Combat;

import java.util.Random;

public class DamageCalculator {

    private final Random random = new Random();

    public int DamageCalculator(int attack, int defense) {
        int baseDamage = Math.max(0,attack - defense);
        int randomDamage = random.nextInt(5)-2;

        return Math.max(0,baseDamage+randomDamage);
    }
}
