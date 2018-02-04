package com.tictactoe;

import com.tictactoe.algo.Board;
import com.tictactoe.algo.MoveResult;
import com.tictactoe.player.ComputerPlayer;
import com.tictactoe.player.HumanPlayer;
import com.tictactoe.player.Players;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TicTacToeGameTest {

    private Board board;
    private Players players;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private TicTacToeGame ticTacToeGame;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        players = mock(Players.class);
        humanPlayer = mock(HumanPlayer.class);
        computerPlayer = mock(ComputerPlayer.class);
        when(players.nextPlayer()).thenReturn(humanPlayer, computerPlayer);


        ticTacToeGame = new TicTacToeGame(board, players);
    }

    @Test
    public void shouldContinuePlayingGameWhenBoardMoveResultIsContinue() throws Exception {
        when(board.executeMove(humanPlayer)).thenReturn(MoveResult.CONTINUE);
        when(board.executeMove(computerPlayer)).thenReturn(MoveResult.WITHDRAWAL);
        ticTacToeGame.start();
        verify(board).executeMove(humanPlayer);
        verify(board).executeMove(computerPlayer);
    }

    @Test
    public void shouldNotContinuePlayingGameWhenBoardMoveResultIsWithdraw() throws Exception {
        when(board.executeMove(humanPlayer)).thenReturn(MoveResult.WITHDRAWAL);
        when(board.executeMove(computerPlayer)).thenReturn(MoveResult.WITHDRAWAL);
        ticTacToeGame.start();
        verify(board).executeMove(humanPlayer);
        verify(board, never()).executeMove(computerPlayer);
    }

    @Test
    public void shouldNotContinuePlayingGameWhenBoardMoveResultIsWon() throws Exception {
        when(board.executeMove(humanPlayer)).thenReturn(MoveResult.GAME_WON);
        when(board.executeMove(computerPlayer)).thenReturn(MoveResult.WITHDRAWAL);
        ticTacToeGame.start();
        verify(board, never()).executeMove(computerPlayer);
    }

    @Test
    public void shouldContinuePlayingGameWithSamePlayerWhenBoardMoveEnterWasWrong() throws Exception {
        when(board.executeMove(humanPlayer)).thenReturn(MoveResult.NOT_ALLOWED, MoveResult.CONTINUE);
        when(board.executeMove(computerPlayer)).thenReturn(MoveResult.WITHDRAWAL);

        ticTacToeGame.start();
        verify(board, times(2)).executeMove(humanPlayer);
        verify(board).executeMove(computerPlayer);
    }
}