package com.game.weapon;

import com.game.engines.BattleField;

public abstract class Weapon {

    public abstract Bullet fire(int x, int y, BattleField battleField);
}
