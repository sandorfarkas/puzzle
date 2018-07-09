package com.atarhely.puzzle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.atarhely.puzzle.Color.*;
import static java.util.Map.entry;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class NodeTest {
	private final List<Integer> testPath = Stream.of(0, 1, 2, 3, 0, 1, 2, 3).collect(Collectors.toList());
	private final String expectedMoves = "->)" + System.lineSeparator()
			+ "<-)" + System.lineSeparator() + "(->" + System.lineSeparator()
			+ "(<-" + System.lineSeparator() + "->)" + System.lineSeparator()
			+ "<-)" + System.lineSeparator() + "(->" + System.lineSeparator()
			+ "(<-" + System.lineSeparator();
	
	@Test
	public void isBoardTheSameAs_ShouldReturnTrueIfBoardIsTheSame() {
		Board board = new Board(Map.ofEntries(
				entry(1, BLUE),
				entry(2, YELLOW),
				entry(3, ORANGE)
		));
		Node node = new Node(new ArrayList<>(), board);
		Board compareBoard = new Board(Map.ofEntries(
				entry(1, BLUE),
				entry(2, YELLOW),
				entry(3, ORANGE)
		));
		
		assertTrue(node.isBoardTheSameAs(compareBoard));
	}
	
	@Test
	public void getMovesFromPath_ShouldReturnCorrectPath() {
		Node node = new Node(testPath, null);
		
		assertThat(node.getMovesFromPath(), is(expectedMoves));
	}
}