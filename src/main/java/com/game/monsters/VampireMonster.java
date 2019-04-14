package com.game.monsters;

import com.game.engines.BattleField;

class VampireMonster extends Monster {

    VampireMonster(int x, int y, BattleField battleField) {
        super(x, y, battleField);
    }

    @Override
    public void move(int steps) {
        battleField.set(x, y, ' ');
        x++;
        battleField.set(x, y, 'V');
    }
}
