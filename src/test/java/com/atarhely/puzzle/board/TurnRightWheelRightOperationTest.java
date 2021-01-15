package com.atarhely.puzzle.board;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.atarhely.puzzle.Color;

public class TurnRightWheelRightOperationTest {
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
	private static final TurnRightWheelRightOperation TURN_RIGHT_WHEEL_RIGHT_OPERATION = new TurnRightWheelRightOperation();
	
	@Test
	public void toString_ShouldReturnLeftBracketLeftArrow() {
		assertEquals("->)", TURN_RIGHT_WHEEL_RIGHT_OPERATION.toString());
	}
	
	@Test
	public void getBoardCopyWithSwappedColors_ShouldReturnBoardWithRightWheelTurnedRight() {
		Map<Integer, Color> swappedColorMap = Map.ofEntries(
				entry(5, BLUE),
				entry(6, YELLOW),
				entry(7, BLUE),
				entry(9, BLUE),
				entry(10, BLUE),
				entry(13, ORANGE),
				entry(14, ORANGE),
				entry(15, YELLOW),
				entry(16, YELLOW),
				entry(17, YELLOW),
				entry(18, ORANGE),
				entry(19, YELLOW)
		);
		Board testBoard = new Board(TEST_BOARD_COLOR_MAP);
		Board swappedBoard = new Board(swappedColorMap);
		
		assertEquals(swappedBoard, TURN_RIGHT_WHEEL_RIGHT_OPERATION.getBoardCopyWithSwappedColors(testBoard));
	}
}