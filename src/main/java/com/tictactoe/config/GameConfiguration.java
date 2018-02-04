package com.tictactoe.config;

public class GameConfiguration {
    private int size;
    private String player1Symbol;
    private String player2Symbol;
    private String player3Symbol;

    GameConfiguration(int size, String player1Symbol,
                      String player2Symbol,
                      String player3Symbol) {
        this.size = size;
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
        this.player3Symbol = player3Symbol;
    }

    public int getSize() {
        return size;
    }

    public String getPlayer1Symbol() {
        return player1Symbol;
    }

    public String getPlayer2Symbol() {
        return player2Symbol;
    }

    public String getPlayer3Symbol() {
        return player3Symbol;
    }
}
