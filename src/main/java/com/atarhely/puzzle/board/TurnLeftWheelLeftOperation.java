package com.atarhely.puzzle.board;

import static java.util.Map.entry;

import java.util.Map;

public class TurnLeftWheelLeftOperation extends Operation {
	public TurnLeftWheelLeftOperation() {
		super(Map.ofEntries(
				entry(1, 5),
				entry(2, 6),
				entry(3, 1),
				entry(4, 2),
				entry(5, 3),
				entry(6, 4),
				entry(7, 9),
				entry(8, 7),
				entry(9, 8),
				entry(10, 12),
				entry(11, 10),
				entry(12, 11))
		);
	}
	
	@Override
	public String toString() {
		return "(<-";
	}
}
