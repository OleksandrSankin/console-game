package com.game.engines;

import jline.console.ConsoleReader;

import java.io.IOException;

public class ConsoleReaderDelegatorImpl implements ConsoleReaderDelegator {

    private ConsoleReader consoleReader;

    public ConsoleReaderDelegatorImpl(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    @Override
    public void print(String value) throws IOException {
        consoleReader.print(value);
    }

    @Override
    public void flush() throws IOException {
        consoleReader.flush();
    }
}
