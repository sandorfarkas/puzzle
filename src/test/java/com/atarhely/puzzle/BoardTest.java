package com.atarhely.puzzle;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.atarhely.puzzle.Color.*;
import static java.util.Map.entry;
import static junit.framework.TestCase.assertTrue;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board(Map.ofEntries(
                entry(1, BLUE),
                entry(2, YELLOW),
                entry(3, ORANGE)
        ));
    }

    @Test
    public void swapColors_ShouldSwapGivenColors() {
        Board targetBoard = new Board(Map.ofEntries(
           entry(1, ORANGE),
           entry(2, BLUE),
           entry(3, YELLOW)
        ));

        Map<Integer, Integer> swaps = Map.ofEntries(
                entry(1, 3),
                entry(2, 1),
                entry(3, 2)
        );

        assertTrue(board.swapColors(swaps).equals(targetBoard));
    }
}
