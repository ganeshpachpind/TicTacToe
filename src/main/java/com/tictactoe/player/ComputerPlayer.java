package com.tictactoe.player;


import com.tictactoe.algo.BoardState;
import com.tictactoe.algo.Move;

public class ComputerPlayer extends Player {
    private final BoardState boardState;

    public ComputerPlayer(String symbol, String name,
                          BoardState boardState) {
        super(symbol, name);
        this.boardState = boardState;
    }

    // Very basic logic just find first free field Refactor and add test
    @Override
    public Move nextMove() {
        String[][] markings = boardState.getMarkings();
        for (int i = 0; i < markings.length; i++) {
            for (int j = 0; j < markings.length; j++) {
                if (markings[i][j] == null) {
                    System.out.println("Computer is making move " + i + "," + j);
                    return new Move(i, j);
                }
            }
        }
        System.out.println("Unable to decide move something wrong");
        return null;
    }
}

