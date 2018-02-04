package com.tictactoe.algo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTacToeRuleTest {

    private BoardState boardState;
    private String symbol;
    private AxialGroupSymbolCount rowSymbolCount;
    private AxialGroupSymbolCount columnsSymbolCount;
    private AxialSymbolCount diagonalSymbolCount;
    private AxialSymbolCount inverseDiagonalSymbolCount;
    private TicTacToeRule ticTacToeRule;
    private int boardSize;

    @Before
    public void setUp() throws Exception {
        symbol = "X";
        boardState = mock(BoardState.class);
        boardSize = 3;

        rowSymbolCount = mock(AxialGroupSymbolCount.class);
        columnsSymbolCount = mock(AxialGroupSymbolCount.class);
        diagonalSymbolCount = mock(AxialSymbolCount.class);
        inverseDiagonalSymbolCount = mock(AxialSymbolCount.class);

        when(boardState.getRowSymbolCount()).thenReturn(rowSymbolCount);
        when(boardState.getColumnSymbolCount()).thenReturn(columnsSymbolCount);
        when(boardState.getDiagonalAxialSymbolCount()).thenReturn(diagonalSymbolCount);
        when(boardState.getInverseDiagonalAxialSymbolCount()).thenReturn(inverseDiagonalSymbolCount);
        when(boardState.getBoardSize()).thenReturn(boardSize);

        ticTacToeRule = new TicTacToeRule();
    }

    @Test
    public void shouldReturnWinningResultWhenInARowSymbolCountSameAsBoardSize() throws Exception {
        int forIndex = 1;

        when(rowSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(true);
        when(columnsSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(diagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);
        when(inverseDiagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);

        MoveResult moveResult = ticTacToeRule.apply(boardState, new Move(forIndex, forIndex), symbol);
        assertEquals(moveResult, MoveResult.GAME_WON);
    }

    @Test
    public void shouldReturnWinningResultWhenInAColumnSymbolCountSameAsBoardSize() throws Exception {
        int forIndex = 1;
        when(rowSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(columnsSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(true);
        when(diagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);
        when(inverseDiagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);

        MoveResult moveResult = ticTacToeRule.apply(boardState, new Move(forIndex, forIndex), symbol);
        assertEquals(moveResult, MoveResult.GAME_WON);
    }

    @Test
    public void shouldReturnWinningResultWhenInADiagonalSymbolCountSameAsBoardSize() throws Exception {
        int forIndex = 1;
        when(rowSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(columnsSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(diagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(true);
        when(inverseDiagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);

        MoveResult moveResult = ticTacToeRule.apply(boardState, new Move(forIndex, forIndex), symbol);
        assertEquals(moveResult, MoveResult.GAME_WON);
    }

    @Test
    public void shouldReturnWinningResultWhenInAInverseDiagonalSymbolCountSameAsBoardSize() throws Exception {
        int xIndex = 0;
        int yIndex = 2;
        when(rowSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, xIndex)).thenReturn(false);
        when(columnsSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, yIndex)).thenReturn(false);
        when(diagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);
        when(inverseDiagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(true);

        MoveResult moveResult = ticTacToeRule.apply(boardState, new Move(xIndex, yIndex), symbol);
        assertEquals(moveResult, MoveResult.GAME_WON);
    }

    @Test
    public void shouldReturnResultWithdrawalWhenBoardIsFull() throws Exception {
        int forIndex = 1;
        when(rowSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(columnsSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(diagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);
        when(inverseDiagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);

        when(boardState.getNumberOfMovesPlayed()).thenReturn(9);

        MoveResult moveResult = ticTacToeRule.apply(boardState, new Move(forIndex, forIndex), symbol);
        assertEquals(moveResult, MoveResult.WITHDRAWAL);
    }

    @Test
    public void shouldReturnResultContinueGameWhenBoardIsNotFull() throws Exception {
        int forIndex = 1;
        when(rowSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(columnsSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex)).thenReturn(false);
        when(diagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);
        when(inverseDiagonalSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize)).thenReturn(false);
        when(boardState.getBoardSize()).thenReturn(3);
        when(boardState.getNumberOfMovesPlayed()).thenReturn(4);

        MoveResult moveResult = ticTacToeRule.apply(boardState, new Move(forIndex, forIndex), symbol);
        assertEquals(moveResult, MoveResult.CONTINUE);
    }
}