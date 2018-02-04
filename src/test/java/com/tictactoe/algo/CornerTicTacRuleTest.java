package com.tictactoe.algo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CornerTicTacRuleTest {

    private CornerTicTacRule cornerTicTacRule;
    private TicTacToeRule ticTacToeRule;
    private BoardState boardState;
    private String symbol;
    private AxialGroupSymbolCount rowSymbolCount;

    @Before
    public void setUp() throws Exception {
        symbol = "X";
        boardState = mock(BoardState.class);
        ticTacToeRule = mock(TicTacToeRule.class);
        rowSymbolCount = mock(AxialGroupSymbolCount.class);
        cornerTicTacRule = new CornerTicTacRule(ticTacToeRule);
    }

    @Test
    public void shouldReturnWinningResultWhenFourCornerMarkedBySameSymbol() throws Exception {
        Move move = new Move(0, 0);
        when(boardState.getRowSymbolCount()).thenReturn(rowSymbolCount);
        when(boardState.getCornerCountFor(symbol)).thenReturn(4);
        when(ticTacToeRule.apply(boardState, move, symbol)).thenReturn(MoveResult.WITHDRAWAL);

        MoveResult moveResult = cornerTicTacRule.apply(boardState, move, symbol);
        assertEquals(MoveResult.GAME_WON, moveResult);
    }

    @Test
    public void shouldReturnContinueResultWhenNotAllFourCornerMarkedBySameSymbol() throws Exception {
        Move move = new Move(0, 0);
        when(boardState.getRowSymbolCount()).thenReturn(rowSymbolCount);
        when(boardState.getCornerCountFor(symbol)).thenReturn(2);
        when(ticTacToeRule.apply(boardState, move, symbol)).thenReturn(MoveResult.WITHDRAWAL);


        MoveResult moveResult = cornerTicTacRule.apply(boardState, move, symbol);
        assertEquals(moveResult, MoveResult.CONTINUE);
    }

    @Test
    public void shouldReturnWinningWhenBasicTicTacRuleResultsWinning() throws Exception {
        Move move = new Move(1, 1);
        when(boardState.getRowSymbolCount()).thenReturn(rowSymbolCount);
        when(boardState.getCornerCountFor(symbol)).thenReturn(2);
        when(ticTacToeRule.apply(boardState, move, symbol)).thenReturn(MoveResult.GAME_WON);

        assertEquals(cornerTicTacRule.apply(boardState, move, symbol), MoveResult.GAME_WON);

    }
}