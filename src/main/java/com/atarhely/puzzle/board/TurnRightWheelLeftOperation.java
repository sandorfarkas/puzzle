package com.atarhely.puzzle.board;

import static java.util.Map.entry;

import java.util.Map;

public class TurnRightWheelLeftOperation extends Operation {
	public TurnRightWheelLeftOperation() {
		super(Map.ofEntries(
				entry(15, 13),
				entry(16, 14),
				entry(7, 15),
				entry(9, 16),
				entry(13, 7),
				entry(14, 9),
				entry(6, 17),
				entry(5, 6),
				entry(17, 5),
				entry(10, 19),
				entry(18, 10),
				entry(19, 18))
		);
	}
	
	@Override
	public String toString() {
		return "<-)";
	}
}
