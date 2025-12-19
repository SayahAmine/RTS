package com.game.core.Combat;

import com.game.core.unit.AbstractUnit;

public class CombatResolver {

    private final DamageCalculator calculator = new DamageCalculator();

    public void resolve(AbstractUnit attacker, AbstractUnit defender) {
        int damage = calculator.DamageCalculator(attacker.getAttack(), defender.getDefense());
        defender.takeDamage(damage);
    }
}
