package com.tictactoe.algo;

public class CornerTicTacRule implements GameRule {

    private TicTacToeRule ticTacToeRule;

    public CornerTicTacRule(TicTacToeRule ticTacToeRule) {
        this.ticTacToeRule = ticTacToeRule;
    }

    @Override
    public MoveResult apply(BoardState boardState, Move move, String symbol) {
        if (boardState.getCornerCountFor(symbol) == 4) {
            return MoveResult.GAME_WON;
        }
        if (ticTacToeRule.apply(boardState, move, symbol).equals(MoveResult.GAME_WON)) {
            return MoveResult.GAME_WON;
        }
        return MoveResult.CONTINUE;
    }
}
