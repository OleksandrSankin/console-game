package com.game.heroes;

import com.game.engines.BattleField;

public class SuperMan extends Hero {

    public SuperMan(BattleField battleField) {
        super(battleField.getHeight(), battleField.getWidth() / 2, battleField);
    }

    @Override
    void show() {
        battleField.set(x, y, 'S');
    }

    @Override
    public void moveLeft() {
        battleField.set(x, y, ' ');
        if (y > 1) {
            y--;
        }
        battleField.set(x, y, 'S');
    }

    @Override
    public void moveRight() {
        battleField.set(x, y, ' ');
        if (y < battleField.getWidth() - 2) {
            y++;
        }
        battleField.set(x, y, 'S');
    }

    @Override
    public void fire() {

    }
}
