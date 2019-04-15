package com.game.heroes;

import com.game.engines.BattleField;
import com.game.weapon.Bullet;
import com.game.weapon.Weapon;

public class SuperMan extends Hero {

    public SuperMan(Weapon weapon, BattleField battleField) {
        super(battleField.getHeight(), battleField.getWidth() / 2, weapon, battleField);
    }

    @Override
    public void draw() {
        battleField.set(x, y, 'S');
    }

    @Override
    public void moveLeft() {
        battleField.set(x, y, ' ');
        if (y > 0) {
            y--;
        }
        battleField.set(x, y, 'S');
    }

    @Override
    public void moveRight() {
        battleField.set(x, y, ' ');
        if (y < battleField.getWidth() - 1) {
            y++;
        }
        battleField.set(x, y, 'S');
    }

    @Override
    public Bullet fire() {
        return weapon.fire(x, y, battleField);
    }
}
