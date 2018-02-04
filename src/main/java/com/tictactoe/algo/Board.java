package com.tictactoe.algo;


import com.tictactoe.player.Player;

public class Board {
    private BoardState boardState;
    private int size;
    private GameRule gameRule;

    public Board(BoardState boardState, int size, GameRule gameRule) {
        this.boardState = boardState;
        this.size = size;
        this.gameRule = gameRule;
    }

    public MoveResult executeMove(Player player) {
        Move move = player.nextMove();
        if (!move.isInValidRange(size)) {
            return MoveResult.NOT_ALLOWED;
        }
        boardState.updateMark(move, player);
        printBoard();
        return gameRule.apply(boardState, move, player.getSymbol());
    }


    // Temp helper just playing game on console
    void printBoard() {
        int boardSize = boardState.getBoardSize();
        String[][] markings = boardState.getMarkings();
        System.out.println("-------------------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(markings[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

}
