package com.tictactoe.player;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayersTest {

    private ArrayList<Player> playerList;
    private Players players;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    @Before
    public void setUp() throws Exception {
        playerList = new ArrayList<>();
        humanPlayer = mock(HumanPlayer.class);
        computerPlayer = mock(ComputerPlayer.class);
        playerList.add(humanPlayer);
        playerList.add(computerPlayer);
    }

    @Test
    public void shouldReturnNextPlayerInSequence() throws Exception {
        players = new Players(playerList);

        Player player = players.nextPlayer();
        assertEquals(humanPlayer, player);

        player = players.nextPlayer();
        assertEquals(computerPlayer, player);

        player = players.nextPlayer();
        assertEquals(humanPlayer, player);
    }
}