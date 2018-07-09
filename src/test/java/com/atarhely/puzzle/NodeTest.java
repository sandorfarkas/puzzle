package com.atarhely.puzzle;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.atarhely.puzzle.board.Board;

public class NodeTest {
	
	@Test
	public void hasTargetBoard_ShouldReturnTrue_WhenBoardIsTargetBoard() {
		List<Board> targetBoards = Board.TARGET_BOARDS;
		Node testNodeWithTargetBoard1 = new Node(null, targetBoards.get(0));
		Node testNodeWithTargetBoard2 = new Node(null, targetBoards.get(1));
		
		assertTrue(testNodeWithTargetBoard1.hasTargetBoard() && testNodeWithTargetBoard2.hasTargetBoard());
	}
	
	@Test
	public void hasTargetBoard_ShouldReturnFalse_WhenBoardIsNotTargetBoard() {
		Board mixedBoard = new Board(Map.ofEntries(
				entry(1, BLUE),
				entry(2, YELLOW),
				entry(3, ORANGE)
		));
		Node testNodeWithNoTargetBoard = new Node(null, mixedBoard);
		
		assertFalse(testNodeWithNoTargetBoard.hasTargetBoard());
	}
}