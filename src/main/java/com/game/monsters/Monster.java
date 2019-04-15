package com.game.monsters;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;

public abstract class Monster {

    final BattleField battleField;

    Coordinate coordinate;

    Monster(Coordinate coordinate, BattleField battleField) {
        this.battleField = battleField;
        this.coordinate = coordinate;
    }

    public abstract void move();

    public void kill() {
        battleField.set(coordinate, 'x');
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
