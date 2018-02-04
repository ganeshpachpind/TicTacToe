package com.tictactoe;


import com.tictactoe.algo.Board;
import com.tictactoe.algo.MoveResult;
import com.tictactoe.player.Player;
import com.tictactoe.player.Players;

class TicTacToeGame {
    private Board board;
    private Players players;

    TicTacToeGame(Board board, Players players) {
        this.board = board;
        this.players = players;
    }

    void start() {
        outerloop:
        do {
            Player player = players.nextPlayer();
            MoveResult moveResult = board.executeMove(player);

            switch (moveResult) {
                case NOT_ALLOWED:
                    System.out.println("Enter move is not allow please enter again.");
                    board.executeMove(player);
                    continue outerloop;

                case GAME_WON:
                    System.out.println(" Won by " + player.getName());
                    break outerloop;

                case WITHDRAWAL:
                    System.out.println("Game Withdraw !!!");
                    break outerloop;

                case CONTINUE:
                    System.out.println("Continue game");
                    continue outerloop;

                default:
                    System.out.println("Continue game");
                    continue outerloop;
            }

        } while (true);
    }
}
