package com.game.app.loop;

import com.game.app.state.GameStat;
import com.game.core.Combat.CombatResolver;
import com.game.core.unit.AbstractUnit;
import com.game.faction.Faction;

import java.util.List;

public class TurnManager {

    private final GameStat state;
    private final CombatResolver combat = new CombatResolver();

    public TurnManager(GameStat state) {
        this.state = state;
    }

    public void nextTurn() {
        state.nextTurn();


        List<Faction> factions = state.getFactions();
        if (factions.size() < 2) {
            return;
        }

        Faction attacker = factions.get(0);
        Faction defender = factions.get(1);

        List<AbstractUnit> attackingUnits = attacker.getUnits();
        List<AbstractUnit> defendingUnits = defender.getUnits();

        if (attackingUnits.isEmpty() || defendingUnits.isEmpty()) {
            return;
        }

        AbstractUnit A = attackingUnits.get(0);
        AbstractUnit B = defendingUnits.get(0);

        combat.resolve(A, B);

        if (!B.IsAlive()) {
            defendingUnits.remove(B);
        }
    }




}
