package com.atarhely.puzzle;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Puzzle {
    private final int MAX_MOVES = 20_000_000;
	Map<Integer, Color> targetBoard = new HashMap<>();
    
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
            if (isTarget(node, targetBoard)) {
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
        Node start = new Node(new ArrayList<>(), Board.SOLUTION_LEFT_BLUE);
        targetBoard = Board.STARS;
        openNodes.add(start);
    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        puzzle.init();
        puzzle.solve();
    }
}
