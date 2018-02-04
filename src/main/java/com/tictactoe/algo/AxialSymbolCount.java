package com.tictactoe.algo;

import java.util.HashMap;

/**
 * Maintains count of symbols for a axis , x axis, y axis, diagonal axis
 */
public class AxialSymbolCount {
    private HashMap<String, Integer> symbolCounts;

    public AxialSymbolCount() {
        this.symbolCounts = new HashMap<>();
    }

    void incrementCountFor(String symbol) {
        symbolCounts.put(symbol, symbolCounts.getOrDefault(symbol, 0) + 1);
    }

    public boolean isSymbolCountMatchBoardSize(String symbol, int boardSize) {
        Integer count = symbolCounts.get(symbol);
        return count != null && count == boardSize;
    }

    HashMap<String, Integer> getSymbolCounts() {
        return symbolCounts;
    }
}
