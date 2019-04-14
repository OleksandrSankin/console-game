package com.game.weapon;

import com.game.engines.BattleField;

public class Gun extends Weapon {

    public Bullet fire(int x, int y, BattleField battleField) {
        return new Bullet(x, y, battleField);
    }
}
