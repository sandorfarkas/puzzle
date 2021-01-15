package com.atarhely.puzzle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.atarhely.puzzle.board.TurnLeftWheelLeftOperation;
import com.atarhely.puzzle.board.TurnLeftWheelRightOperation;
import com.atarhely.puzzle.board.TurnRightWheelLeftOperation;
import com.atarhely.puzzle.board.TurnRightWheelRightOperation;

public class PathTest {
	private static final TurnLeftWheelLeftOperation TURN_LEFT_WHEEL_LEFT = new TurnLeftWheelLeftOperation();
	private static final TurnLeftWheelRightOperation TURN_LEFT_WHEEL_RIGHT = new TurnLeftWheelRightOperation();
	private static final TurnRightWheelLeftOperation TURN_RIGHT_WHEEL_LEFT = new TurnRightWheelLeftOperation();
	private static final TurnRightWheelRightOperation TURN_RIGHT_WHEEL_RIGHT = new TurnRightWheelRightOperation();
	
	private final Path testPath = new Path(Stream.of(TURN_RIGHT_WHEEL_RIGHT, TURN_RIGHT_WHEEL_LEFT,
			TURN_LEFT_WHEEL_RIGHT, TURN_LEFT_WHEEL_LEFT, TURN_RIGHT_WHEEL_RIGHT,
			TURN_RIGHT_WHEEL_LEFT, TURN_LEFT_WHEEL_RIGHT, TURN_LEFT_WHEEL_LEFT)
			.collect(Collectors.toList()));
	private final String expectedMoves = "->)" + System.lineSeparator()
			+ "<-)" + System.lineSeparator() + "(->" + System.lineSeparator()
			+ "(<-" + System.lineSeparator() + "->)" + System.lineSeparator()
			+ "<-)" + System.lineSeparator() + "(->" + System.lineSeparator()
			+ "(<-" + System.lineSeparator();
	
	@Test
	public void getCopyWithStepAdded_ShouldReturnPathWithExtraStep() {
		Path expectedPath = testPath.getCopyWithStepAdded(TURN_RIGHT_WHEEL_LEFT);
		
		assertThat(expectedPath.toString(), is(expectedMoves  + "<-)" + System.lineSeparator()));
	}
	
	@Test
	public void numberOfSteps_ShouldReturnTheNumberOfStepsInPath() {
		assertEquals(8, testPath.numberOfSteps());
	}
	
	@Test
	public void toString_ShouldReturnCorrectPath() {
		Node node = new Node(testPath, null);
		
		Path path = node.getPath();
		assertThat(path.toString(), is(expectedMoves));
	}
}