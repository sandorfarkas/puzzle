package com.atarhely.puzzle.board;

import java.util.HashMap;
import java.util.Map;

import com.atarhely.puzzle.Color;

public abstract class Operation {
	private final Map<Integer, Integer> swaps;
	
	Operation(Map<Integer, Integer> swaps) {
		this.swaps = swaps;
	}
	
	public Board getBoardCopyWithSwappedColors(Board originalBoard) {
		Map<Integer, Color> colorMap = originalBoard.getColorMap();
		Map<Integer, Color> swappedColorMap = new HashMap<>();
		
		for (Map.Entry<Integer, Color> colorEntry : colorMap.entrySet()) {
			swappedColorMap.put(colorEntry.getKey(),
					(swaps.containsKey(colorEntry.getKey())
							? colorMap.get(swaps.get(colorEntry.getKey()))
							: colorEntry.getValue()));
		}
		return new Board(swappedColorMap);
	}
}
