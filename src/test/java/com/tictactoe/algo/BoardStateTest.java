package com.tictactoe.algo;

import com.tictactoe.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BoardStateTest {

    private AxialSymbolCount diagonalCount;
    private AxialSymbolCount inverseDiagonalCount;
    private AxialGroupSymbolCount rowAxisGroup;
    private AxialGroupSymbolCount columnAxisGroup;
    private Player player;
    private String symbol;
    private BoardState boardState;

    @Before
    public void setUp() throws Exception {
        diagonalCount = mock(AxialSymbolCount.class);
        inverseDiagonalCount = mock(AxialSymbolCount.class);
        rowAxisGroup = mock(AxialGroupSymbolCount.class);
        columnAxisGroup = mock(AxialGroupSymbolCount.class);
        player = mock(Player.class);
        symbol = "X";
        when(player.getSymbol()).thenReturn(symbol);

        int boardSize = 3;
        boardState = new BoardState(boardSize, diagonalCount,
                inverseDiagonalCount, rowAxisGroup, columnAxisGroup);
    }

    @Test
    public void shouldIncrementDiagonalRowsAndColumnCountWhenMarkWithDiagonalMove() throws Exception {
        int forIndex = 0;

        boardState.updateMark(new Move(forIndex, forIndex), player);

        verify(diagonalCount).incrementCountFor(symbol);
        verify(inverseDiagonalCount,never()).incrementCountFor(symbol);
        verify(rowAxisGroup).incrementCountFor(symbol, forIndex);
        verify(columnAxisGroup).incrementCountFor(symbol, forIndex);
        assertEquals(boardState.getNumberOfMovesPlayed(), 1);
    }

    @Test
    public void shouldIncrementDiagonalsRowsAndColumnCountWhenMarkWithDiagonalCenterMove() throws Exception {
        int forIndex = 1;

        boardState.updateMark(new Move(forIndex, forIndex), player);

        verify(diagonalCount).incrementCountFor(symbol);
        verify(inverseDiagonalCount).incrementCountFor(symbol);
        verify(rowAxisGroup).incrementCountFor(symbol, forIndex);
        verify(columnAxisGroup).incrementCountFor(symbol, forIndex);
        assertEquals(boardState.getNumberOfMovesPlayed(), 1);
    }

    @Test
    public void shouldIncrementInverseDiagonalRowsAndColumnCountWhenMarkWithInverseDiagonalMove() throws Exception {
        int xIndex = 0;
        int yIndex = 2;

        boardState.updateMark(new Move(xIndex, yIndex), player);

        verify(diagonalCount, never()).incrementCountFor(symbol);
        verify(inverseDiagonalCount).incrementCountFor(symbol);
        verify(rowAxisGroup).incrementCountFor(symbol, xIndex);
        verify(columnAxisGroup).incrementCountFor(symbol, yIndex);
        assertEquals(boardState.getNumberOfMovesPlayed(), 1);
    }

    @Test
    public void shouldIncrementRowsAndColumnCountWhenMarkWithNonDiagonalMove() throws Exception {
        int xIndex = 0;
        int yIndex = 1;

        boardState.updateMark(new Move(xIndex, yIndex), player);

        verify(diagonalCount, never()).incrementCountFor(symbol);
        verify(inverseDiagonalCount, never()).incrementCountFor(symbol);
        verify(rowAxisGroup).incrementCountFor(symbol, xIndex);
        verify(columnAxisGroup).incrementCountFor(symbol, yIndex);
        assertEquals(boardState.getNumberOfMovesPlayed(), 1);
    }


}