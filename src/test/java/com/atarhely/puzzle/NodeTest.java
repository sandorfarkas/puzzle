package com.atarhely.puzzle;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.atarhely.puzzle.board.Board;

public class NodeTest {
	@Test
	public void isBoardTheSameAs_ShouldReturnTrueIfBoardIsTheSame() {
		Board board = new Board(Map.ofEntries(
				entry(1, BLUE),
				entry(2, YELLOW),
				entry(3, ORANGE)
		));
		Node node = new Node(Path.GENESIS_PATH, board);
		Board compareBoard = new Board(Map.ofEntries(
				entry(1, BLUE),
				entry(2, YELLOW),
				entry(3, ORANGE)
		));
		
		assertTrue(node.isBoardTheSameAs(compareBoard));
	}
}