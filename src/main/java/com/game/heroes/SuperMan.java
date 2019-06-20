package com.game.heroes;

import com.game.engines.BattleField;
import com.game.engines.Coordinate;
import com.game.weapon.Bullet;
import com.game.weapon.Weapon;

public class SuperMan extends Hero {

    public SuperMan(Weapon weapon, BattleField battleField) {
        super(new Coordinate(battleField.getHeight() - 1, battleField.getWidth() / 2), weapon, battleField);
    }

    @Override
    public void draw() {
        battleField.set(coordinate, 'S');
    }

    @Override
    public void moveLeft() {
        battleField.set(coordinate, ' ');

        if (coordinate.getY() > 0) {
            int y = coordinate.getY();
            coordinate = new Coordinate(coordinate.getX(), --y);
        }

        battleField.set(coordinate, 'S');
    }

    @Override
    public void moveRight() {
        battleField.set(coordinate, ' ');

        if (coordinate.getY() < battleField.getWidth() - 1) {
            int y = coordinate.getY();
            coordinate = new Coordinate(coordinate.getX(), ++y);
        }

        battleField.set(coordinate, 'S');
    }








    @Override
    public Bullet fire() {
        return weapon.fire(coordinate, battleField);
    }
}
