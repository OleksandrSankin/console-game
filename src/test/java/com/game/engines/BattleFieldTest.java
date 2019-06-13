package com.game.engines;

import jline.console.ConsoleReader;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class BattleFieldTest {

    @Test
    public void testWidhtAndHeight() throws IOException {
        BattleField battleField = new BattleField(10, 10, new ConsoleReaderDelegator() {

            @Override
            public void print(String value) throws IOException {

            }

            @Override
            public void flush() throws IOException {

            }
        });

        assertEquals(10, battleField.getWidth());
        assertEquals(10, battleField.getHeight());
    }

    @Test
    public void testRender() throws IOException {
        String expectedField =
                " ----------\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                " ----------\n";

        BattleField battleField = new BattleField(10, 10, new ConsoleReaderDelegator() {

            @Override
            public void print(String value) throws IOException {
                assertEquals(expectedField, value);
            }

            @Override
            public void flush() throws IOException {

            }
        });
        battleField.render();
    }
}
