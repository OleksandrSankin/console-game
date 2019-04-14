package com.game.monsters;

import com.game.engines.BattleField;

import java.util.Random;

public class MonsterFactory {

    private Random random = new Random();

    public Monster buildMonster(BattleField battleField) {
        int y = random.nextInt(battleField.getWidth());

        if (y % 2 == 0) {
            return new VampireMonster(0, y, battleField);
        } else {
            return new ZombieMonster(0, y, battleField);
        }
    }
}
