package com.game.weapon;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;

public class Gun extends Weapon {

    public Bullet fire(Coordinate coordinate, BattleField battleField) {
        return new Bullet(coordinate, battleField);
    }
}
