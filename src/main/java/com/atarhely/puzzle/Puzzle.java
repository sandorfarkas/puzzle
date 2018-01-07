package com.atarhely.puzzle;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Puzzle {
    private final int MAX_MOVES = 20_000_000;
    
    final Set<Integer> closedNodes = new HashSet<>();
    private final Queue<Node> openNodes = new ArrayDeque<>();

    private Node operationRightWheelRight(Node node) {
        Map<Integer, Color> board = node.getBoard();
        Map<Integer, Color> newBoard = node.getBoardCopy();

        newBoard.put(15, board.get(7));
        newBoard.put(16, board.get(9));
        newBoard.put(7, board.get(13));
        newBoard.put(9, board.get(14));
        newBoard.put(13, board.get(15));
        newBoard.put(14, board.get(16));
        newBoard.put(6, board.get(5));
        newBoard.put(5, board.get(17));
        newBoard.put(17, board.get(6));
        newBoard.put(10, board.get(18));
        newBoard.put(18, board.get(19));
        newBoard.put(19, board.get(10));

        List<Integer> newPath = node.getPathCopy();
        newPath.add(0);
        Node newNode = new Node(newPath, newBoard);
        return newNode;
    }

    private Node operationRightWheelLeft(Node node) {
        Map<Integer, Color> board = node.getBoard();
        Map<Integer, Color> newBoard = node.getBoardCopy();

        newBoard.put(15, board.get(13));
        newBoard.put(16, board.get(14));
        newBoard.put(7, board.get(15));
        newBoard.put(9, board.get(16));
        newBoard.put(13, board.get(7));
        newBoard.put(14, board.get(9));
        newBoard.put(6, board.get(17));
        newBoard.put(5, board.get(6));
        newBoard.put(17, board.get(5));
        newBoard.put(10, board.get(19));
        newBoard.put(18, board.get(10));
        newBoard.put(19, board.get(18));

        List<Integer> newPath = node.getPathCopy();
        newPath.add(1);
        Node newNode = new Node(newPath, newBoard);
        return newNode;
    }

    private Node operationLeftWheelRight(Node node) {
        Map<Integer, Color> board = node.getBoard();
        Map<Integer, Color> newBoard = node.getBoardCopy();

        newBoard.put(1, board.get(3));
        newBoard.put(2, board.get(4));
        newBoard.put(3, board.get(5));
        newBoard.put(4, board.get(6));
        newBoard.put(5, board.get(1));
        newBoard.put(6, board.get(2));
        newBoard.put(7, board.get(8));
        newBoard.put(8, board.get(9));
        newBoard.put(9, board.get(7));
        newBoard.put(10, board.get(11));
        newBoard.put(11, board.get(12));
        newBoard.put(12, board.get(10));

        List<Integer> newPath = node.getPathCopy();
        newPath.add(2);
        Node newNode = new Node(newPath, newBoard);
        return newNode;
    }

    private Node operationLeftWheelLeft(Node node) {
        Map<Integer, Color> board = node.getBoard();
        Map<Integer, Color> newBoard = node.getBoardCopy();

        newBoard.put(1, board.get(5));
        newBoard.put(2, board.get(6));
        newBoard.put(3, board.get(1));
        newBoard.put(4, board.get(2));
        newBoard.put(5, board.get(3));
        newBoard.put(6, board.get(4));
        newBoard.put(7, board.get(9));
        newBoard.put(8, board.get(7));
        newBoard.put(9, board.get(8));
        newBoard.put(10, board.get(12));
        newBoard.put(11, board.get(10));
        newBoard.put(12, board.get(11));

        List<Integer> newPath = node.getPathCopy();
        newPath.add(3);
        Node newNode = new Node(newPath, newBoard);
        return newNode;
    }

    boolean isClosed(Node node) {
        return closedNodes.contains(node.hashCode());
    }

    boolean isTarget(Node node) {
        Map<Integer, Color> board = node.getBoard();
        return board.get(5).equals(Color.ORANGE)
                && board.get(6).equals(Color.ORANGE)
                && board.get(7).equals(Color.ORANGE)
                && board.get(9).equals(Color.ORANGE)
                && board.get(10).equals(Color.ORANGE)
                && board.get(13).equals(board.get(14))
                && board.get(14).equals(board.get(15))
                && board.get(15).equals(board.get(16))
                && board.get(16).equals(board.get(17))
                && board.get(17).equals(board.get(18))
                && board.get(18).equals(board.get(19));
    }

    boolean isTarget(Node node, Map<Integer, Color> targetBoard) {
        return node.compareBoardTo(targetBoard);
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

            Node rr = operationRightWheelRight(node);
            if (!isClosed(rr)) {
                openNodes.add(rr);
            }

            Node rl = operationRightWheelLeft(node);
            if (!isClosed(rl)) {
                openNodes.add(rl);
            }

            Node lr = operationLeftWheelRight(node);
            if (!isClosed(lr)) {
                openNodes.add(lr);
            }

            Node ll = operationLeftWheelLeft(node);
            if (!isClosed(ll)) {
                openNodes.add(ll);
            }

            closedNodes.add(node.hashCode());
            moves++;
        }
        System.out.println("No solution");
        System.out.println("Closed " + closedNodes.size());
        System.out.println("Open " + openNodes.size());
        if (openNodes.size() > 0) {
            System.out.println(openNodes.remove().getPath());
        }
    }

    private void init() {
        Map<Integer, Color> startBoard = new HashMap<>();
        startBoard.put(1, Color.YELLOW);
        startBoard.put(2, Color.YELLOW);
        startBoard.put(3, Color.YELLOW);
        startBoard.put(4, Color.YELLOW);
        startBoard.put(5, Color.ORANGE);
        startBoard.put(6, Color.ORANGE);
        startBoard.put(7, Color.YELLOW);
        startBoard.put(8, Color.BLUE);
        startBoard.put(9, Color.ORANGE);
        startBoard.put(10, Color.ORANGE);
        startBoard.put(11, Color.YELLOW);
        startBoard.put(12, Color.YELLOW);
        startBoard.put(13, Color.BLUE);
        startBoard.put(14, Color.BLUE);
        startBoard.put(15, Color.ORANGE);
        startBoard.put(16, Color.BLUE);
        startBoard.put(17, Color.BLUE);
        startBoard.put(18, Color.BLUE);
        startBoard.put(19, Color.BLUE);
        
        /*startBoard.put(1, Color.BLUE);
        startBoard.put(2, Color.BLUE);
        startBoard.put(3, Color.ORANGE);
        startBoard.put(4, Color.BLUE);
        startBoard.put(5, Color.YELLOW);
        startBoard.put(6, Color.ORANGE);
        startBoard.put(7, Color.ORANGE);
        startBoard.put(8, Color.BLUE);
        startBoard.put(9, Color.ORANGE);
        startBoard.put(10, Color.ORANGE);
        startBoard.put(11, Color.BLUE);
        startBoard.put(12, Color.BLUE);
        startBoard.put(13, Color.YELLOW);
        startBoard.put(14, Color.YELLOW);
        startBoard.put(15, Color.YELLOW);
        startBoard.put(16, Color.YELLOW);
        startBoard.put(17, Color.BLUE);
        startBoard.put(18, Color.YELLOW);
        startBoard.put(19, Color.YELLOW);*/

        Node start = new Node(new ArrayList<>(), startBoard);
        openNodes.add(start);
        
        /*Map<Integer, Color> targetBoard1 = new HashMap<>();
        targetBoard1.put(1, Color.YELLOW);
        targetBoard1.put(2, Color.YELLOW);
        targetBoard1.put(3, Color.YELLOW);
        targetBoard1.put(4, Color.YELLOW);
        targetBoard1.put(5, Color.ORANGE);
        targetBoard1.put(6, Color.ORANGE);
        targetBoard1.put(7, Color.ORANGE);
        targetBoard1.put(8, Color.YELLOW);
        targetBoard1.put(9, Color.ORANGE);
        targetBoard1.put(10, Color.ORANGE);
        targetBoard1.put(11, Color.YELLOW);
        targetBoard1.put(12, Color.YELLOW);
        targetBoard1.put(13, Color.BLUE);
        targetBoard1.put(14, Color.BLUE);
        targetBoard1.put(15, Color.BLUE);
        targetBoard1.put(16, Color.BLUE);
        targetBoard1.put(17, Color.BLUE);
        targetBoard1.put(18, Color.BLUE);
        targetBoard1.put(19, Color.BLUE);
        target1 = new Node(new ArrayList<>(), targetBoard1);
	
		Map<Integer, Color> targetBoard2 = new HashMap<>();
        targetBoard2.put(1, Color.BLUE);
		targetBoard2.put(2, Color.BLUE);
		targetBoard2.put(3, Color.BLUE);
		targetBoard2.put(4, Color.BLUE);
		targetBoard2.put(5, Color.ORANGE);
		targetBoard2.put(6, Color.ORANGE);
		targetBoard2.put(7, Color.ORANGE);
		targetBoard2.put(8, Color.BLUE);
		targetBoard2.put(9, Color.ORANGE);
		targetBoard2.put(10, Color.ORANGE);
		targetBoard2.put(11, Color.BLUE);
		targetBoard2.put(12, Color.BLUE);
		targetBoard2.put(13, Color.YELLOW);
		targetBoard2.put(14, Color.YELLOW);
		targetBoard2.put(15, Color.YELLOW);
		targetBoard2.put(16, Color.YELLOW);
		targetBoard2.put(17, Color.YELLOW);
		targetBoard2.put(18, Color.YELLOW);
		targetBoard2.put(19, Color.YELLOW);
		target2 = new Node(new ArrayList<>(), targetBoard1);*/
    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        puzzle.init();
        puzzle.solve();
    }
}
