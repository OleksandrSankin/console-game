package com.game;

import com.game.engines.BattleField;
import com.game.engines.ConsoleReaderDelegatorImpl;
import com.game.engines.SimpleEngine;
import com.game.heroes.SuperMan;
import com.game.monsters.MonsterFactory;
import com.game.weapon.Gun;
import jline.console.ConsoleReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ConsoleReader console = new ConsoleReader();
        ConsoleReaderDelegatorImpl consoleReaderDelegator
                = new ConsoleReaderDelegatorImpl(console);

        BattleField battleField = new BattleField(25, 18, consoleReaderDelegator);
        SuperMan hero = new SuperMan(new Gun(), battleField);

        SimpleEngine gameEngine = new SimpleEngine(hero, battleField,
                new MonsterFactory(), 3, console);
        gameEngine.runGame();
    }
}
