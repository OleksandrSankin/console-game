package com.game.engines;

import java.io.IOException;

public interface ConsoleReaderDelegator {

    void print(String value) throws IOException;

    void flush() throws IOException;
}
