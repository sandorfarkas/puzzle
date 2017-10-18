package com.atarhely.puzzle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class NodeTest {
    @Test
    public void copyPath() {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        path.add(2);
        Node node = new Node(path, new HashMap<>());
        List<Integer> pathCopy = node.getPathCopy();
        assertTrue(pathCopy.size() == 2);
    }

    @Test
    public void copyBoard() {
        Map<Integer, Color> board = new HashMap<>();
        board.put(1, Color.BLUE);
        board.put(2, Color.YELLOW);
        board.put(3, Color.ORANGE);

        Node node = new Node(new ArrayList<>(), board);

        Map<Integer, Color> compareBoard = new HashMap<>();
        compareBoard.put(1, Color.BLUE);
        compareBoard.put(2, Color.YELLOW);
        compareBoard.put(3, Color.ORANGE);

        assertTrue(node.compareBoardTo(compareBoard));
    }
}
