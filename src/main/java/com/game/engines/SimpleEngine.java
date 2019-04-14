package com.game.engines;

import com.game.heroes.Hero;
import com.game.monsters.Monster;
import com.game.monsters.MonsterFactory;
import com.game.weapon.Bullet;
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

    private List<Bullet> bullets = new ArrayList<>();

    public SimpleEngine(BattleField battleField, Hero hero, MonsterFactory monsterFactory, ConsoleReader console) {
        this.monsterFactory = monsterFactory;
        this.battleField = battleField;
        this.console = console;
        this.hero = hero;

        addNewMonstersIfNeeded();
    }

    public void runGame() throws IOException {

        cleanScreen();

        while (heroIsAlive()) {

            addNewMonstersIfNeeded();

            moveMonstersDown();

            moveBulletsUp();

            showHero();

            renderBattleField();

            waitForPlayerAction();

            cleanScreen();
        }
    }

    private void moveBulletsUp() {
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).move();
        }
    }

    private void waitForPlayerAction() throws IOException {
        Action action = readKeyBoard();
        if (action == Action.Left) {
            hero.moveLeft();
        } else if (action == Action.Right) {
            hero.moveRight();
        } else if (action == Action.Fire) {
            Bullet bullet = hero.fire();
            bullets.add(bullet);
        }
    }

    private boolean heroIsAlive() {
        return true;
    }

    private void moveMonstersDown() {
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

    private void showHero() {
        hero.draw();
    }

    private void renderBattleField() throws IOException {
        battleField.render();
    }

    private void cleanScreen() throws IOException {
        console.clearScreen();
    }

    private Action readKeyBoard() throws IOException {
        KeyMap map = new KeyMap("");
        map.bind("\u001B[A", Action.Fire);
        map.bind("\u001B[D", Action.Left);
        map.bind("\u001B[C", Action.Right);
        return (Action) console.readBinding(map);
    }
}
