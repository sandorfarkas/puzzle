package com.atarhely.puzzle;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import lombok.RequiredArgsConstructor;

import com.atarhely.puzzle.board.Board;
import com.atarhely.puzzle.board.TurnLeftWheelLeftOperation;
import com.atarhely.puzzle.board.TurnLeftWheelRightOperation;
import com.atarhely.puzzle.board.TurnRightWheelLeftOperation;
import com.atarhely.puzzle.board.TurnRightWheelRightOperation;

@RequiredArgsConstructor
public class Puzzle {
	private static final int MAX_MOVES = 20_000_000;
	private static final TurnLeftWheelLeftOperation TURN_LEFT_WHEEL_LEFT = new TurnLeftWheelLeftOperation();
	private static final TurnLeftWheelRightOperation TURN_LEFT_WHEEL_RIGHT = new TurnLeftWheelRightOperation();
	private static final TurnRightWheelLeftOperation TURN_RIGHT_WHEEL_LEFT = new TurnRightWheelLeftOperation();
	private static final TurnRightWheelRightOperation TURN_RIGHT_WHEEL_RIGHT = new TurnRightWheelRightOperation();
	
	private final Set<Integer> closedNodeHashes = new HashSet<>();
	private final Queue<Node> openNodes = new ArrayDeque<>();
	
	private boolean isNotClosed(Node node) {
		return !closedNodeHashes.contains(node.hashCode());
	}
	
	private void generateOpenNodes(Node node) {
		Node ll = node.getExtendedNode(TURN_LEFT_WHEEL_LEFT);
		if (isNotClosed(ll)) {
			openNodes.add(ll);
		}
		Node lr = node.getExtendedNode(TURN_LEFT_WHEEL_RIGHT);
		if (isNotClosed(lr)) {
			openNodes.add(lr);
		}
		Node rl = node.getExtendedNode(TURN_RIGHT_WHEEL_LEFT);
		if (isNotClosed(rl)) {
			openNodes.add(rl);
		}
		Node rr = node.getExtendedNode(TURN_RIGHT_WHEEL_RIGHT);
		if (isNotClosed(rr)) {
			openNodes.add(rr);
		}
	}
	
	private void solve() {
		int moves = 0;
		
		while (moves < MAX_MOVES) {
			if (openNodes.isEmpty()) {
				break;
			}
			
			Node node = openNodes.remove();
			
			if (node.hasTargetBoard()) {
				System.out.println("Number of steps: " + node.getPath().numberOfSteps());
				System.out.println(node.getPath());
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
		Node start = new Node(Path.GENESIS_PATH, Board.START);
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