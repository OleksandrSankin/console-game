package com.game.weapon;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;

public final class Bullet {

    private final BattleField battleField;

    private Coordinate coordinate;

    Bullet(Coordinate coordinate, BattleField battleField) {
        this.battleField = battleField;
        this.coordinate = coordinate;
    }

    public void move() {
        battleField.set(coordinate, ' ');

        if (coordinate.getX() > 0) {
            int x = coordinate.getX();
            coordinate = new Coordinate(--x, coordinate.getY());
        }

        battleField.set(coordinate, '^');
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
