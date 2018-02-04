package com.tictactoe.config;

import java.io.IOException;

public interface ConfigReader {
    GameConfiguration readGameConfig() throws IOException;
}
