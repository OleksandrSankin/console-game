package com.game.weapon;

import com.game.engines.BattleField;

public final class Bullet {

    private final BattleField battleField;

    private int x;

    private int y;

    Bullet(int x, int y, BattleField battleField) {
        this.battleField = battleField;
        this.x = x;
        this.y = y;
    }

    public void move() {
        battleField.set(x, y, ' ');
        if (x > 0) {
            x--;
        }
        battleField.set(x, y, '^');
    }
}
