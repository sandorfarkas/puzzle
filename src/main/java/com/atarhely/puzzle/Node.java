package com.atarhely.puzzle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import com.atarhely.puzzle.board.Board;
import com.atarhely.puzzle.board.Operation;

@RequiredArgsConstructor
public class Node {
	@Getter private final Path path;
	@Getter private final Board board;
	
	public boolean hasTargetBoard() {
		for (Board targetBoard : Board.TARGET_BOARDS) {
			if (board.equals(targetBoard)) {
				return true;
			}
		}
		return false;
	}
	
	public Node getExtendedNode(Operation operation) {
		Path newPath = path.getCopyWithStepAdded(operation);
		Board newBoard = operation.getBoardCopyWithSwappedColors(board);
		
		return new Node(newPath, newBoard);
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
		return board.hashCode();
	}
}
