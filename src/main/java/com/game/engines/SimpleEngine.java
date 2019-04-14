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

    private final int totalNumberOfMonstersOnScreen;

    private int numberOfMonsters;

    private final MonsterFactory monsterFactory;

    private final ConsoleReader console;

    private final Hero hero;

    private final List<Monster> monsters = new ArrayList<>();

    private final List<Bullet> bullets = new ArrayList<>();

    public SimpleEngine(Hero hero,
                        BattleField battleField,
                        MonsterFactory monsterFactory,
                        int totalNumberOfMonstersOnScreen,
                        ConsoleReader console) {
        this.totalNumberOfMonstersOnScreen = totalNumberOfMonstersOnScreen;
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

            checkIfSomeMonstersAreKilled();

            showHero();

            renderBattleField();

            waitForPlayerAction();

            cleanScreen();
        }

        gameOver();
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
        for (int j = 0; j < monsters.size(); j++) {
            Monster monster = monsters.get(j);
            if (hero.getCoordinate().getX() == monster.getCoordinate().getX()
                    && hero.getCoordinate().getY() == monster.getCoordinate().getY()) {
                return false;
            }
        }

        return true;
    }

    private void moveMonstersDown() {
        for (int i = numberOfMonsters; i > 0; i--) {
            Monster monster = monsters.get(i - 1);
            monster.move(1);
        }
    }

    private void addNewMonstersIfNeeded() {
        if (numberOfMonsters < totalNumberOfMonstersOnScreen) {
            for (int i = numberOfMonsters; i < totalNumberOfMonstersOnScreen; i++) {
                Monster monster = monsterFactory.buildMonster(battleField);
                monsters.add(monster);
                numberOfMonsters++;
            }
        }
    }

    private void checkIfSomeMonstersAreKilled() {
        List<Monster> monstersForRemoved = new ArrayList<>();
        List<Bullet> bulletsForRemoved = new ArrayList<>();

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < monsters.size(); j++) {
                Bullet bullet = bullets.get(i);
                Monster monster = monsters.get(j);

                if (bullet.getCoordinate().getX() == monster.getCoordinate().getX()
                        && bullet.getCoordinate().getY() == monster.getCoordinate().getY())
                {
                    monstersForRemoved.add(monster);
                    bulletsForRemoved.add(bullet);
                }
            }
        }

        for (int i = 0; i < monstersForRemoved.size(); i++) {
            Monster monster = monstersForRemoved.get(i);
            monster.kill();
            monsters.remove(monster);
            numberOfMonsters--;
        }

        for (int i = 0; i < bulletsForRemoved.size(); i++) {
            bullets.remove(bulletsForRemoved.get(i));
        }
    }

    private void gameOver() throws IOException {
        console.clearScreen();
        console.print("GAME OVER");
        console.flush();
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
