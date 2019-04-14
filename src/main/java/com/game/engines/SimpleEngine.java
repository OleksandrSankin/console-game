package com.game.engines;

import com.game.heroes.Hero;
import com.game.monsters.Monster;
import com.game.monsters.MonsterFactory;
import jline.console.ConsoleReader;
import jline.console.KeyMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleEngine {

    private final BattleField battleField;
    private final MonsterFactory monsterFactory;

    private final ConsoleReader console;

    private final Hero hero;

    private int numberOfMonsters;

    private List<Monster> monsters = new ArrayList<>();

    public SimpleEngine(BattleField battleField, Hero hero, MonsterFactory monsterFactory, ConsoleReader console) {
        this.monsterFactory = monsterFactory;
        this.battleField = battleField;
        this.console = console;
        this.hero = hero;

        addNewMonstersIfNeeded();
    }

    public void runGame() throws IOException {
        console.clearScreen();

        while (heroIsAlive()) {

            addNewMonstersIfNeeded();

            moveMonstersForward();

            battleField.render();

            waitForPlayerAction();

            console.clearScreen();
        }
    }

    private void waitForPlayerAction() throws IOException {
        Action action = readKeyBoard();
        if (action == Action.Left) {
            hero.moveLeft();
        } else if (action == Action.Right) {
            hero.moveRight();
        } else if (action == Action.Fire) {
            hero.fire();
        }
    }

    private boolean heroIsAlive() {
        return true;
    }

    private void moveMonstersForward() {
        for (int i = numberOfMonsters; i > 0; i--) {
            Monster monster = monsters.get(i - 1);
            monster.move(1);
        }
    }

    private void addNewMonstersIfNeeded() {
        if (numberOfMonsters < 5) {
            for (int i = numberOfMonsters; i < 5; i++) {
                Monster monster = monsterFactory.buildMonster(battleField);
                monsters.add(monster);
                numberOfMonsters++;
            }
        }
    }

    private Action readKeyBoard() throws IOException {
        KeyMap map = new KeyMap("");
        map.bind("\u001B[A", Action.Fire);
        map.bind("\u001B[D", Action.Left);
        map.bind("\u001B[C", Action.Right);
        return (Action) console.readBinding(map);
    }
}
