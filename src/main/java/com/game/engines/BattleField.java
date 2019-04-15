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

        field = renderHorizontalBorder(field);

        for (int x = 0; x < getHeight(); x++) {
            for (int y = 0; y < getWidth(); y++) {
                field = renderLine(field, x, y);
            }
            field += '\n';
        }

        field = renderHorizontalBorder(field);

        console.print(field);
        console.flush();
    }

    private String renderLine(String field, int x, int y) {
        if (y == 0) {
            field += '|';
        }

        field += battleField[x][y];

        if (y == getWidth() - 1) {
            field += '|';
        }

        return field;
    }

    private String renderHorizontalBorder(String field) {
        field += ' ';
        for (int i = 1; i < getWidth() + 1; i++) {
            field += '-';
        }
        field += '\n';
        return field;
    }

    private void clean() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                battleField[i][j] = ' ';
            }
        }
    }
}
