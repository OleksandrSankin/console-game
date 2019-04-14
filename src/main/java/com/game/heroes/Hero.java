package com.game.heroes;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;
import com.game.weapon.Bullet;
import com.game.weapon.Weapon;

public abstract class Hero {

    final BattleField battleField;

    final Weapon weapon;

    int x;

    int y;

    Hero(int x, int y, Weapon weapon, BattleField battleField) {
        this.weapon = weapon;
        this.battleField = battleField;
        this.x = x - 2;
        this.y = y;

        this.draw();
    }

    public abstract void draw();

    public abstract void moveLeft();

    public abstract void moveRight();

    public abstract Bullet fire();

    public Coordinate getCoordinate() {
        return new Coordinate(x, y);
    }
}
