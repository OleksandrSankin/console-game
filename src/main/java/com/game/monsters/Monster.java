package com.game.monsters;

import com.game.engines.BattleField;

public abstract class Monster {

    final BattleField battleField;

    int x;

    int y;

    Monster(int x, int y, BattleField battleField) {
        this.battleField = battleField;
        this.x = x;
        this.y = y;
    }

    public abstract void move(int steps);
}
