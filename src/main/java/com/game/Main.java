package com.game;

import com.game.engines.BattleField;
import com.game.engines.SimpleEngine;
import com.game.heroes.SuperMan;
import com.game.monsters.MonsterFactory;
import jline.console.ConsoleReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ConsoleReader console = new ConsoleReader();
        BattleField battleField = new BattleField(25, 18, console);
        MonsterFactory monsterFactory = new MonsterFactory();
        SuperMan hero = new SuperMan(battleField);

        SimpleEngine gameEngine = new SimpleEngine(battleField, hero, monsterFactory, console);
        gameEngine.runGame();
    }
}
