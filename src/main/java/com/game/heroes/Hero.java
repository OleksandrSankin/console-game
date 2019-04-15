package com.game.heroes;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;
import com.game.weapon.Bullet;
import com.game.weapon.Weapon;

public abstract class Hero {

    final BattleField battleField;

    final Weapon weapon;

    Coordinate coordinate;

    Hero(Coordinate coordinate, Weapon weapon, BattleField battleField) {
        this.battleField = battleField;
        this.coordinate = coordinate;
        this.weapon = weapon;
        this.draw();
    }

    public abstract void draw();

    public abstract void moveLeft();

    public abstract void moveRight();

    public abstract Bullet fire();

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
