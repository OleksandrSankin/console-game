package com.game.weapon;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;

public abstract class Weapon {

    public abstract Bullet fire(Coordinate coordinate, BattleField battleField);
}
