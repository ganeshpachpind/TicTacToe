package com.tictactoe.algo;


import com.tictactoe.player.Player;

/**
 * Maintains the board played state to calculate game is won or to continue
 */
public class BoardState {
    private int boardSize;
    private String[][] markings;

    private int numberOfMovesPlayed;
    private AxialSymbolCount diagonalAxialSymbolCount;
    private AxialSymbolCount inverseDiagonalAxialSymbolCount;
    private AxialGroupSymbolCount rowsSymbolCount;
    private AxialGroupSymbolCount columnsSymbolCount;

    public BoardState(int boardSize,
                      AxialSymbolCount diagonalAxialSymbolCount,
                      AxialSymbolCount inverseDiagonalAxialSymbolCount,
                      AxialGroupSymbolCount rowsSymbolCount, AxialGroupSymbolCount columnsSymbolCount) {
        this.boardSize = boardSize;
        this.diagonalAxialSymbolCount = diagonalAxialSymbolCount;
        this.markings = new String[boardSize][boardSize];
        this.inverseDiagonalAxialSymbolCount = inverseDiagonalAxialSymbolCount;
        this.rowsSymbolCount = rowsSymbolCount;
        this.columnsSymbolCount = columnsSymbolCount;
    }

    void updateMark(Move move, Player player) {
        int x = move.getX();
        int y = move.getY();
        if (x == y) {
            diagonalAxialSymbolCount.incrementCountFor(player.getSymbol());
        }
        // don't change to else if test added
        if ((boardSize - y - 1) == x) {
            inverseDiagonalAxialSymbolCount.incrementCountFor(player.getSymbol());
        }

        rowsSymbolCount.incrementCountFor(player.getSymbol(), x);
        columnsSymbolCount.incrementCountFor(player.getSymbol(), y);

        markings[x][y] = player.getSymbol();
        numberOfMovesPlayed++;
    }

    public String[][] getMarkings() {
        return markings;
    }

    int getNumberOfMovesPlayed() {
        return numberOfMovesPlayed;
    }

    int getBoardSize() {
        return boardSize;
    }

    AxialSymbolCount getDiagonalAxialSymbolCount() {
        return diagonalAxialSymbolCount;
    }

    AxialSymbolCount getInverseDiagonalAxialSymbolCount() {
        return inverseDiagonalAxialSymbolCount;
    }

    AxialGroupSymbolCount getRowSymbolCount() {
        return rowsSymbolCount;
    }

    AxialGroupSymbolCount getColumnSymbolCount() {
        return columnsSymbolCount;
    }

    public int getCornerCountFor(String symbol) {
        return 0;
    }
}
