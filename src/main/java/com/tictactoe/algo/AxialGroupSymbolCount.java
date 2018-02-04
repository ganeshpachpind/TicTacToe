package com.tictactoe.algo;

/**
 * Maintains counts of symbol for group of axis
 * Array [ row[0], row[1] row[3] ]
 */
public class AxialGroupSymbolCount {
    private AxialSymbolCount[] groupSymbolsCount;
    private int size;

    public AxialGroupSymbolCount(int boardSize) {
        this.size = boardSize;
        this.groupSymbolsCount = new AxialSymbolCount[boardSize];
    }

    void incrementCountFor(String symbol, int forIndex) {
        if (groupSymbolsCount[forIndex] != null) {
            groupSymbolsCount[forIndex].incrementCountFor(symbol);
        } else {
            groupSymbolsCount[forIndex] = new AxialSymbolCount();
            groupSymbolsCount[forIndex].incrementCountFor(symbol);
        }
    }

    public boolean isSymbolCountAtIndexMatchBoardSize(String symbol, int forIndex) {
        return groupSymbolsCount[forIndex] != null &&
                groupSymbolsCount[forIndex].isSymbolCountMatchBoardSize(symbol, size);
    }


}
