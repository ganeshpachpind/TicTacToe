package com.tictactoe;


import com.tictactoe.algo.*;
import com.tictactoe.config.FileConfigReader;
import com.tictactoe.config.GameConfiguration;
import com.tictactoe.input.ConsoleInputReader;
import com.tictactoe.player.ComputerPlayer;
import com.tictactoe.player.HumanPlayer;
import com.tictactoe.player.Player;
import com.tictactoe.player.Players;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.playGame();
    }

    private void playGame() throws IOException, NullPointerException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader
                .getResource("config.properties")
                .getFile());

        FileConfigReader fileConfigReader = new FileConfigReader(file);
        GameConfiguration gameConfiguration = fileConfigReader.readGameConfig();

        int size = gameConfiguration.getSize();
        BoardState boardState = new BoardState(size, new AxialSymbolCount(), new AxialSymbolCount(),
                new AxialGroupSymbolCount(size), new AxialGroupSymbolCount(size));


        Player player1 = new HumanPlayer(gameConfiguration.getPlayer1Symbol(), "Player 1", new ConsoleInputReader());
        Player player2 = new HumanPlayer(gameConfiguration.getPlayer2Symbol(), "Player 2", new ConsoleInputReader());
        Player player3 = new ComputerPlayer(gameConfiguration.getPlayer3Symbol(), "Computer", boardState);

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        Players players = new Players(playerList);
        GameRule gameRule = new TicTacToeRule();
        Board board = new Board(boardState, size, gameRule);

        TicTacToeGame ticTacToeGame = new TicTacToeGame(board, players);
        ticTacToeGame.start();
    }
}
