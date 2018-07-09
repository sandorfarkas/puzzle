package com.atarhely.puzzle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class PathTest {
	private final Path testPath = new Path(Stream.of(0, 1, 2, 3, 0, 1, 2, 3).collect(Collectors.toList()));
	private final String expectedMoves = "->)" + System.lineSeparator()
			+ "<-)" + System.lineSeparator() + "(->" + System.lineSeparator()
			+ "(<-" + System.lineSeparator() + "->)" + System.lineSeparator()
			+ "<-)" + System.lineSeparator() + "(->" + System.lineSeparator()
			+ "(<-" + System.lineSeparator();
	
	@Test
	public void getCopyWithStepAdded_ShouldReturnPathWithExtraStep() {
		Path expectedPath = testPath.getCopyWithStepAdded(1);
		
		assertThat(expectedPath.toString(), is(expectedMoves  + "<-)" + System.lineSeparator()));
	}
	
	@Test
	public void toString_ShouldReturnCorrectPath() {
		Node node = new Node(testPath, null);
		
		Path path = node.getPath();
		assertThat(path.toString(), is(expectedMoves));
	}
}