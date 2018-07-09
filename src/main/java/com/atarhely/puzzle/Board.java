package com.atarhely.puzzle;

import static com.atarhely.puzzle.Color.BLUE;
import static com.atarhely.puzzle.Color.ORANGE;
import static com.atarhely.puzzle.Color.YELLOW;
import static java.util.Map.entry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Board {
	static final Board START = new Board(Map.ofEntries(
			entry(1, YELLOW),
			entry(2, BLUE),
			entry(3, ORANGE),
			entry(4, YELLOW),
			entry(5, YELLOW),
			entry(6, ORANGE),
			entry(7, ORANGE),
			entry(8, BLUE),
			entry(9, ORANGE),
			entry(10, BLUE),
			entry(11, BLUE),
			entry(12, ORANGE),
			entry(13, BLUE),
			entry(14, BLUE),
			entry(15, YELLOW),
			entry(16, BLUE),
			entry(17, YELLOW),
			entry(18, YELLOW),
			entry(19, YELLOW)
	));
	private static final Board SOLUTION_LEFT_BLUE = new Board(Map.ofEntries(
			entry(1, BLUE),
			entry(2, BLUE),
			entry(3, BLUE),
			entry(4, BLUE),
			entry(5, ORANGE),
			entry(6, ORANGE),
			entry(7, ORANGE),
			entry(8, BLUE),
			entry(9, ORANGE),
			entry(10, ORANGE),
			entry(11, BLUE),
			entry(12, BLUE),
			entry(13, YELLOW),
			entry(14, YELLOW),
			entry(15, YELLOW),
			entry(16, YELLOW),
			entry(17, YELLOW),
			entry(18, YELLOW),
			entry(19, YELLOW)
	));
	private static final Board SOLUTION_LEFT_YELLOW = new Board(Map.ofEntries(
			entry(1, YELLOW),
			entry(2, YELLOW),
			entry(3, YELLOW),
			entry(4, YELLOW),
			entry(5, ORANGE),
			entry(6, ORANGE),
			entry(7, ORANGE),
			entry(8, YELLOW),
			entry(9, ORANGE),
			entry(10, ORANGE),
			entry(11, YELLOW),
			entry(12, YELLOW),
			entry(13, BLUE),
			entry(14, BLUE),
			entry(15, BLUE),
			entry(16, BLUE),
			entry(17, BLUE),
			entry(18, BLUE),
			entry(19, BLUE)
	));
	static final List<Board> TARGET_BOARDS = List.of(SOLUTION_LEFT_BLUE, SOLUTION_LEFT_YELLOW);
	
	@Getter private final Map<Integer, Color> colorMap;
	
	Board getCopyWithSwappedColors(Map<Integer, Integer> swaps) {
		Map<Integer, Color> swappedColorMap = new HashMap<>();
		for (Map.Entry<Integer, Color> colorEntry : colorMap.entrySet()) {
			swappedColorMap.put(colorEntry.getKey(),
					(swaps.containsKey(colorEntry.getKey())
							? colorMap.get(swaps.get(colorEntry.getKey()))
							: colorEntry.getValue()));
		}
		return new Board(swappedColorMap);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Board board = (Board) o;
		for (Map.Entry<Integer, Color> entry : board.colorMap.entrySet()) {
			if (!entry.getValue().equals(this.colorMap.get(entry.getKey()))) {
				return false;
			}
		}
		return true;
	}
}