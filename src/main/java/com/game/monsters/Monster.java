package com.game.monsters;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;

public abstract class Monster {

    final BattleField battleField;

    int x;

    int y;

    Monster(int x, int y, BattleField battleField) {
        this.battleField = battleField;
        this.x = x;
        this.y = y;
    }

    public abstract void move();

    public void kill() {
        battleField.set(x, y, 'x');
    }

    public Coordinate getCoordinate() {
        return new Coordinate(x, y);
    }
}
