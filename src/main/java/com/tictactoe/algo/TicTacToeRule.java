package com.tictactoe.algo;

public class TicTacToeRule implements GameRule {

    private boolean isWin(BoardState boardState, Move move, String symbol) {
        int boardSize = boardState.getBoardSize();
        int x = move.getX();
        int y = move.getY();
        return boardState.getRowSymbolCount().isSymbolCountAtIndexMatchBoardSize(symbol, x) ||
                boardState.getColumnSymbolCount().isSymbolCountAtIndexMatchBoardSize(symbol, y) ||
                boardState.getDiagonalAxialSymbolCount().isSymbolCountMatchBoardSize(symbol, boardSize) ||
                boardState.getInverseDiagonalAxialSymbolCount().isSymbolCountMatchBoardSize(symbol, boardState.getBoardSize());
    }

    private boolean isWithdraw(BoardState boardState) {
        int boardSize = boardState.getBoardSize();
        int numberOfMovesAllowed = (boardSize * boardSize);
        return boardState.getNumberOfMovesPlayed() == numberOfMovesAllowed;
    }

    @Override
    public MoveResult apply(BoardState boardState, Move move, String symbol) {
        if (isWin(boardState, move, symbol)) {
            return MoveResult.GAME_WON;
        } else if (isWithdraw(boardState)) {
            return MoveResult.WITHDRAWAL;
        }
        return MoveResult.CONTINUE;
    }
}
