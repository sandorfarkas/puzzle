package com.atarhely.puzzle;

import static java.util.Map.entry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Puzzle {
	private static final int MAX_MOVES = 20_000_000;
	
	private final Set<Integer> closedNodeHashes = new HashSet<>();
	private final Queue<Node> openNodes = new ArrayDeque<>();
	
	private Node operationRightWheelRight(Node node) {
		Map<Integer, Integer> swaps = Map.ofEntries(
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
				entry(19, 10)
		);
		return createExtendedNode(node, swaps, 0);
	}
	
	private Node operationRightWheelLeft(Node node) {
		Map<Integer, Integer> swaps = Map.ofEntries(
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
				entry(19, 18)
		);
		return createExtendedNode(node, swaps, 1);
	}
	
	private Node operationLeftWheelRight(Node node) {
		Map<Integer, Integer> swaps = Map.ofEntries(
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
				entry(12, 10)
		);
		return createExtendedNode(node, swaps, 2);
	}
	
	private Node operationLeftWheelLeft(Node node) {
		Map<Integer, Integer> swaps = Map.ofEntries(
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
				entry(12, 11)
		);
		return createExtendedNode(node, swaps, 3);
	}
	
	private Node createExtendedNode(Node node, Map<Integer, Integer> swaps, Integer operationId) {
		Board board = node.getBoard();
		Board newBoard = board.swapColors(swaps);
		
		List<Integer> newPath = new ArrayList<>(node.getPath());
		newPath.add(operationId);
		return new Node(newPath, newBoard);
	}
	
	private boolean isNotClosed(Node node) {
		return !closedNodeHashes.contains(node.hashCode());
	}
	
	private boolean isTarget(Node node) {
		for (Board targetBoard : Board.TARGET_BOARDS) {
			if (node.isBoardTheSameAs(targetBoard)) {
				return true;
			}
		}
		return false;
	}
	
	private void generateOpenNodes(Node node) {
		Node rr = operationRightWheelRight(node);
		if (isNotClosed(rr)) {
			openNodes.add(rr);
		}
		
		Node rl = operationRightWheelLeft(node);
		if (isNotClosed(rl)) {
			openNodes.add(rl);
		}
		
		Node lr = operationLeftWheelRight(node);
		if (isNotClosed(lr)) {
			openNodes.add(lr);
		}
		
		Node ll = operationLeftWheelLeft(node);
		if (isNotClosed(ll)) {
			openNodes.add(ll);
		}
	}
	
	private void solve() {
		int moves = 0;
		
		while (moves < MAX_MOVES) {
			if (openNodes.isEmpty()) {
				break;
			}
			
			Node node = openNodes.remove();
			
			if (isTarget(node)) {
				System.out.println(node.getMovesFromPath());
				return;
			}
			
			generateOpenNodes(node);
			
			closedNodeHashes.add(node.hashCode());
			moves++;
		}
		
		System.out.println("No solution");
		System.out.println("Closed " + closedNodeHashes.size());
		System.out.println("Open " + openNodes.size());
		
		if (openNodes.size() > 0) {
			System.out.println(openNodes.remove().getPath());
		}
	}
	
	private void init() {
		Node start = new Node(new ArrayList<>(), Board.START);
		openNodes.add(start);
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Puzzle puzzle = new Puzzle();
		puzzle.init();
		puzzle.solve();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}