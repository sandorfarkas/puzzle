package com.atarhely.puzzle;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PuzzleTest {
    Puzzle puzzle;

    @Before
    public void init() {
        Map<Integer, Color> board = new HashMap<>();
        board.put(1, Color.BLUE);
        board.put(2, Color.YELLOW);
        board.put(3, Color.ORANGE);

        //puzzle = new Puzzle(board, new ArrayList<Integer>());
    }

    @Test
    public void whenComparingDifferentBoardWithSameContent_ShouldReturnTrue() {
        Map<Integer, Color> board = new HashMap<>();
        board.put(1, Color.BLUE);
        board.put(2, Color.YELLOW);
        board.put(3, Color.ORANGE);

        //assertTrue(puzzle.compare(board));
    }

    @Test
    public void isClosed() {
        Map<Integer, Color> board1 = new HashMap<>();
        board1.put(1, Color.BLUE);
        board1.put(2, Color.YELLOW);
        board1.put(3, Color.ORANGE);

        Map<Integer, Color> board2 = new HashMap<>();
        board2.put(1, Color.BLUE);
        board2.put(2, Color.YELLOW);
        board2.put(3, Color.ORANGE);

        Node node1 = new Node(new ArrayList<>(), board1);
        Node node2 = new Node(new ArrayList<>(), board2);

        puzzle = new Puzzle();
        puzzle.closedNodes.add(node1.hashCode());

        assertTrue(puzzle.isClosed(node2));
    }

}
