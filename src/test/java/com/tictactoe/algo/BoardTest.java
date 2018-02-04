package com.tictactoe.algo;

import com.tictactoe.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

    private int size;
    private Player player;
    private Move move;
    private BoardState boardState;
    private Board board;
    private GameRule gameRule;

    @Before
    public void setUp() throws Exception {
        size = 3;
        player = mock(Player.class);
        move = mock(Move.class);
        boardState = mock(BoardState.class);
        gameRule = mock(GameRule.class);
        board = new Board(boardState, size, gameRule);
        when(player.nextMove()).thenReturn(move);
    }

    @Test
    public void ShouldReturnMoveNotAllowedWhenPlayerEntersInvalidMove() throws Exception {
        when(move.isInValidRange(size)).thenReturn(false);
        assertEquals(MoveResult.NOT_ALLOWED, board.executeMove(player));
    }


    @Test
    public void ShouldReturnResultFromRules() throws Exception {
        when(move.isInValidRange(size)).thenReturn(true);
        when(gameRule.apply(any(), any(), any())).thenReturn(MoveResult.WITHDRAWAL);
        assertEquals(MoveResult.WITHDRAWAL, board.executeMove(player));
    }

}