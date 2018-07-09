package com.atarhely.puzzle.board;

import static java.util.Map.entry;

import java.util.Map;

public class TurnRightWheelRightOperation extends Operation {
	public TurnRightWheelRightOperation() {
		super(Map.ofEntries(
				entry(15, 7),
				entry(16, 9),
				entry(7, 13),
				entry(9, 14),
				entry(13, 15),
				entry(14, 16),
				entry(6, 5),
				entry(5, 17),
				entry(17, 6),
				entry(10, 18),
				entry(18, 19),
				entry(19, 10))
		);
	}
	
	@Override
	public String toString() {
		return "->)";
	}
}
