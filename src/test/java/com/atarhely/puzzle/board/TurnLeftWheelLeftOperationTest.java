package com.atarhely.puzzle.board;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.atarhely.puzzle.Color;

public class TurnLeftWheelLeftOperationTest {
	private static final Map<Integer, Color> TEST_BOARD_COLOR_MAP = Map.ofEntries(
			entry(1, YELLOW),
			entry(2, YELLOW),
			entry(3, BLUE),
			entry(4, BLUE),
			entry(5, ORANGE),
			entry(6, ORANGE),
			entry(7, YELLOW),
			entry(8, YELLOW),
			entry(9, BLUE),
			entry(10, ORANGE),
			entry(11, YELLOW),
			entry(12, BLUE)
	);
	private static final TurnLeftWheelLeftOperation TURN_LEFT_WHEEL_LEFT_OPERATION = new TurnLeftWheelLeftOperation();
	
	@Test
	public void toString_ShouldReturnLeftBracketLeftArrow() {
		assertEquals("(<-", TURN_LEFT_WHEEL_LEFT_OPERATION.toString());
	}
	
	@Test
	public void getBoardCopyWithSwappedColors_ShouldReturnBoardWithLeftWheelTurnedLeft() {
		Map<Integer, Color> swappedColorMap = Map.ofEntries(
				entry(1, ORANGE),
				entry(2, ORANGE),
				entry(3, YELLOW),
				entry(4, YELLOW),
				entry(5, BLUE),
				entry(6, BLUE),
				entry(7, BLUE),
				entry(8, YELLOW),
				entry(9, YELLOW),
				entry(10, BLUE),
				entry(11, ORANGE),
				entry(12, YELLOW)
		);
		Board testBoard = new Board(TEST_BOARD_COLOR_MAP);
		Board swappedBoard = new Board(swappedColorMap);
		
		assertEquals(swappedBoard, TURN_LEFT_WHEEL_LEFT_OPERATION.getBoardCopyWithSwappedColors(testBoard));
	}
}