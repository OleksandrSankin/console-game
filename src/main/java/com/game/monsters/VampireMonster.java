package com.game.monsters;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;

class VampireMonster extends Monster {

    VampireMonster(Coordinate coordinate, BattleField battleField) {
        super(coordinate, battleField);
    }

    @Override
    public void move() {
        battleField.set(coordinate, ' ');

        int x = coordinate.getX();
        coordinate = new Coordinate(++x, coordinate.getY());

        battleField.set(coordinate, 'V');
    }
}
