package com.tictactoe.algo;

public interface GameRule {
    MoveResult apply(BoardState boardState, Move move, String symbol);
}
