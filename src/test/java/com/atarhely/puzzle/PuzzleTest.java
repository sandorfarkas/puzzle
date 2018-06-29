//package com.atarhely.puzzle;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertTrue;
//
//public class PuzzleTest {
//    Puzzle puzzle = new Puzzle();
//
//    @Before
//    public void init() {
//    }
//
//    @Test
//    public void isClosed() {
//        Node node1 = new Node(new ArrayList<>(), BoardTest.IDENTICAL_BOARD_1);
//        Node node2 = new Node(new ArrayList<>(), BoardTest.IDENTICAL_BOARD_2);
//
//        puzzle.closedNodes.add(node1.hashCode());
//
//        assertTrue(puzzle.isClosed(node2));
//    }
//
//    @Test
//    public void whenOperationRightWheelRight_ShouldRearrangeColors() {
//        //puzzle.operationRightWheelRight(BoardTest.START);
//    }
//}
