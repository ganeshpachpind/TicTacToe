package com.tictactoe.algo;

import com.tictactoe.algo.Move;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveTest {
    @Test
    public void shouldReturnTrueWhenXAndYCordinateAreWithinRange() throws Exception {
        Move move = new Move(1,1);
        assertTrue(move.isInValidRange(2));

    }

    @Test
    public void shouldReturnFalseWhenXCordinateAreNotWithinRange() throws Exception {
        Move move = new Move(4,1);
        assertFalse(move.isInValidRange(2));
    }

    @Test
    public void shouldReturnFalseWhenYCordinateAreNotWithinRange() throws Exception {
        Move move = new Move(1,4);
        assertFalse(move.isInValidRange(2));
    }
}