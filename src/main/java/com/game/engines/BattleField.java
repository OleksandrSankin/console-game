package com.game.engines;

import jline.console.ConsoleReader;

import java.io.IOException;

public class BattleField {

    private final char[][] battleField;

    private final ConsoleReader console;

    public BattleField(int height, int width, ConsoleReader console) {
        this.battleField = new char[height][width];
        this.console = console;
        this.clean();
    }

    public int getWidth() {
        return battleField[0].length;
    }

    public int getHeight() {
        return battleField.length;
    }

    public void set(int x, int y, char symbol) {
        battleField[x][y] = symbol;
    }

    void render() throws IOException {
        String field = "";

        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (i == 0 || i == battleField.length - 1) {
                    field += '-';
                } else if (j == 0 || j == battleField[i].length - 1) {
                    field += '|';
                } else {
                    field += battleField[i][j];
                }
            }

            field += '\n';
        }

        console.print(field);
        console.flush();
    }

    private void clean() {
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                battleField[i][j] = ' ';
            }
        }
    }
}
