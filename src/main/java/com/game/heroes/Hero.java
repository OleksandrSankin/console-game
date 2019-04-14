package com.game.heroes;

import com.game.engines.BattleField;

public abstract class Hero {

    final BattleField battleField;

    int x;

    int y;

    public Hero(int x, int y, BattleField battleField) {
        this.battleField = battleField;
        this.x = x - 2;
        this.y = y;

        this.show();
    }

    abstract void show();

    public abstract void moveLeft();

    public abstract void moveRight();

    public abstract void fire();
}
