package com.game;

import com.game.engines.BattleField;
import com.game.engines.SimpleEngine;
import com.game.heroes.SuperMan;
import com.game.monsters.MonsterFactory;
import com.game.weapon.Gun;
import jline.console.ConsoleReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ConsoleReader console = new ConsoleReader();
        BattleField battleField = new BattleField(25, 18, console);
        SuperMan hero = new SuperMan(new Gun(), battleField);

        SimpleEngine gameEngine = new SimpleEngine(hero, battleField,
                new MonsterFactory(), 5, console);
        gameEngine.runGame();
    }
}
