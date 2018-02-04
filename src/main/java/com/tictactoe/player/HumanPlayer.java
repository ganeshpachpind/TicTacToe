package com.tictactoe.player;


import com.tictactoe.algo.Move;
import com.tictactoe.input.InputReader;

public class HumanPlayer extends Player {
    private final InputReader reader;

    public HumanPlayer(String symbol, String name, InputReader reader) {
        super(symbol, name);
        this.reader = reader;
    }

    @Override
    public Move nextMove() {
        Move playerMove = reader.getPlayerMove();
        return playerMove;
    }
}
