package com.atarhely.puzzle.board;

import static java.util.Map.entry;

import java.util.Map;

public class TurnLeftWheelRightOperation extends Operation {
	public TurnLeftWheelRightOperation() {
		super(Map.ofEntries(
				entry(1, 3),
				entry(2, 4),
				entry(3, 5),
				entry(4, 6),
				entry(5, 1),
				entry(6, 2),
				entry(7, 8),
				entry(8, 9),
				entry(9, 7),
				entry(10, 11),
				entry(11, 12),
				entry(12, 10))
		);
	}
	
	@Override
	public String toString() {
		return "(->";
	}
}
