package com.tictactoe.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AxialSymbolCountTest {

    private AxialSymbolCount axialSymbolCount;

    @Before
    public void setUp() throws Exception {
        axialSymbolCount = new AxialSymbolCount();
    }

    @Test
    public void shouldIncrementRowCountForGivenSymbolTo1WhenNoCountAvailable() throws Exception {
        axialSymbolCount.incrementCountFor("X");
        HashMap<String, Integer> playersCount = axialSymbolCount.getSymbolCounts();
        assertEquals(playersCount.get("X"), new Integer(1));
    }

    @Test
    public void shouldIncrementRowCountForGivenSymbolTo2WhenCountAvailable() throws Exception {
        String symbolX = "X";
        String symbolY = "Y";

        axialSymbolCount.incrementCountFor(symbolX);
        axialSymbolCount.incrementCountFor(symbolY);
        axialSymbolCount.incrementCountFor(symbolX);

        HashMap<String, Integer> symbolCounts = axialSymbolCount.getSymbolCounts();
        assertEquals(symbolCounts.get(symbolX), new Integer(2));
        assertEquals(symbolCounts.get(symbolY), new Integer(1));
    }

    @Test
    public void shouldReturnTrueForWinningMove() throws Exception {
        String symbol = "X";
        int boardSize = 3;
        axialSymbolCount.incrementCountFor(symbol);
        axialSymbolCount.incrementCountFor(symbol);
        axialSymbolCount.incrementCountFor(symbol);

        assertTrue(axialSymbolCount.isSymbolCountMatchBoardSize(symbol, boardSize));
    }
}