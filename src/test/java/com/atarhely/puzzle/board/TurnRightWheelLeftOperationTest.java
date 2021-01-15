package com.atarhely.puzzle.board;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.atarhely.puzzle.Color;

public class TurnRightWheelLeftOperationTest {
	private static final Map<Integer, Color> TEST_BOARD_COLOR_MAP = Map.ofEntries(
			entry(5, YELLOW),
			entry(6, YELLOW),
			entry(7, YELLOW),
			entry(9, YELLOW),
			entry(10, YELLOW),
			entry(13, BLUE),
			entry(14, BLUE),
			entry(15, ORANGE),
			entry(16, ORANGE),
			entry(17, BLUE),
			entry(18, BLUE),
			entry(19, ORANGE)
	);
	private static final TurnRightWheelLeftOperation TURN_RIGHT_WHEEL_LEFT_OPERATION = new TurnRightWheelLeftOperation();
	
	@Test
	public void toString_ShouldReturnLeftBracketLeftArrow() {
		assertEquals("<-)", TURN_RIGHT_WHEEL_LEFT_OPERATION.toString());
	}
	
	@Test
	public void getBoardCopyWithSwappedColors_ShouldReturnBoardWithRightWheelTurnedLeft() {
		Map<Integer, Color> swappedColorMap = Map.ofEntries(
				entry(5, YELLOW),
				entry(6, BLUE),
				entry(7, ORANGE),
				entry(9, ORANGE),
				entry(10, ORANGE),
				entry(13, YELLOW),
				entry(14, YELLOW),
				entry(15, BLUE),
				entry(16, BLUE),
				entry(17, YELLOW),
				entry(18, YELLOW),
				entry(19, BLUE)
		);
		Board testBoard = new Board(TEST_BOARD_COLOR_MAP);
		Board swappedBoard = new Board(swappedColorMap);
		
		assertEquals(swappedBoard, TURN_RIGHT_WHEEL_LEFT_OPERATION.getBoardCopyWithSwappedColors(testBoard));
	}
}