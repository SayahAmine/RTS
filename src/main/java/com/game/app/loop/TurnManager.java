package com.game.app.loop;

import com.game.app.state.GameStat;
import com.game.core.Combat.CombatResolver;
import com.game.core.unit.AbstractUnit;

import java.util.List;

public class TurnManager {

    private final GameStat state;
    private final CombatResolver combat = new CombatResolver();

    public TurnManager(GameStat state) {
        this.state = state;
    }

    public void nextTurn(){
        state.nextTurn();


        List<AbstractUnit> units = state.getUnits();

        while (units.size() >= 2) {
            AbstractUnit A = units.get(0);
            AbstractUnit B = units.get(1);
            combat.resolve(A, B);
            if (!B.IsAlive()) {
                units.remove(B);
            }
        }


    }
}
