package com.atarhely.puzzle.board;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.atarhely.puzzle.Color;

public class TurnLeftWheelRightOperationTest {
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
	private static final TurnLeftWheelRightOperation TURN_LEFT_WHEEL_RIGHT_OPERATION = new TurnLeftWheelRightOperation();
	
	@Test
	public void toString_ShouldReturnLeftBracketLeftArrow() {
		assertEquals("(->", TURN_LEFT_WHEEL_RIGHT_OPERATION.toString());
	}
	
	@Test
	public void getBoardCopyWithSwappedColors_ShouldReturnBoardWithLeftWheelTurnedRight() {
		Map<Integer, Color> swappedColorMap = Map.ofEntries(
				entry(1, BLUE),
				entry(2, BLUE),
				entry(3, ORANGE),
				entry(4, ORANGE),
				entry(5, YELLOW),
				entry(6, YELLOW),
				entry(7, YELLOW),
				entry(8, BLUE),
				entry(9, YELLOW),
				entry(10, YELLOW),
				entry(11, BLUE),
				entry(12, ORANGE)
		);
		Board testBoard = new Board(TEST_BOARD_COLOR_MAP);
		Board swappedBoard = new Board(swappedColorMap);
		
		assertEquals(swappedBoard, TURN_LEFT_WHEEL_RIGHT_OPERATION.getBoardCopyWithSwappedColors(testBoard));
	}
}