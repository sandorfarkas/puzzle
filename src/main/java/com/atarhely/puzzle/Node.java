package com.atarhely.puzzle;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Node {
	@Getter private final List<Integer> path;
	@Getter private final Board board;
	
	boolean isBoardTheSameAs(Board board) {
		return this.board.getColorMap().equals(board.getColorMap());
	}
	
	String getMovesFromPath() {
		StringBuilder sb = new StringBuilder();
		for (Integer i : path) {
			switch (i) {
				case 0:
					sb.append("->)").append(System.lineSeparator());
					break;
				case 1:
					sb.append("<-)").append(System.lineSeparator());
					break;
				case 2:
					sb.append("(->").append(System.lineSeparator());
					break;
				case 3:
					sb.append("(<-").append(System.lineSeparator());
					break;
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Node node = (Node) o;
		
		return board != null ? board.getColorMap().equals(node.board.getColorMap()) : node.board == null;
	}
	
	@Override
	public int hashCode() {
		String hash = "" + board.getColorMap().get(1).ordinal()
				+ board.getColorMap().get(1).ordinal()
				+ board.getColorMap().get(2).ordinal()
				+ board.getColorMap().get(3).ordinal()
				+ board.getColorMap().get(4).ordinal()
				+ board.getColorMap().get(5).ordinal()
				+ board.getColorMap().get(6).ordinal()
				+ board.getColorMap().get(7).ordinal()
				+ board.getColorMap().get(8).ordinal()
				+ board.getColorMap().get(9).ordinal()
				+ board.getColorMap().get(10).ordinal()
				+ board.getColorMap().get(11).ordinal()
				+ board.getColorMap().get(12).ordinal()
				+ board.getColorMap().get(13).ordinal()
				+ board.getColorMap().get(14).ordinal()
				+ board.getColorMap().get(15).ordinal()
				+ board.getColorMap().get(16).ordinal()
				+ board.getColorMap().get(17).ordinal()
				+ board.getColorMap().get(18).ordinal()
				+ board.getColorMap().get(19).ordinal();
		return board != null ? hash.hashCode() : 0;
	}
}
