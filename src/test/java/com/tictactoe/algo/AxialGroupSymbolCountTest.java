package com.tictactoe.algo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AxialGroupSymbolCountTest {
    @Test
    public void shouldReturnTrueForWinningGameWhenForIndexSymbolCountIsEqualToBoardSize() throws Exception {
        AxialGroupSymbolCount axialGroupSymbolCount = new AxialGroupSymbolCount(3);
        String symbol = "X";
        int forIndex = 0;
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);

        assertTrue(axialGroupSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex));
    }

    @Test
    public void shouldReturnFalseForWinningGameWhenForIndexSymbolCountIsLessThanToBoardSize() throws Exception {
        AxialGroupSymbolCount axialGroupSymbolCount = new AxialGroupSymbolCount(3);
        String symbol = "X";
        int forIndex = 0;
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);

        assertFalse(axialGroupSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol, forIndex));
    }

    @Test
    public void shouldReturnFalseForWinningGameWhenForIndexSymbolCountIsGreaterThanToBoardSize() throws Exception {
        AxialGroupSymbolCount axialGroupSymbolCount = new AxialGroupSymbolCount(3);
        String symbol = "X";
        int forIndex = 0;
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);
        axialGroupSymbolCount.incrementCountFor(symbol, forIndex);

        assertFalse(axialGroupSymbolCount.isSymbolCountAtIndexMatchBoardSize(symbol,forIndex));
    }
}