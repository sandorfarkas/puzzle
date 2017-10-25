package com.atarhely.puzzle;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Puzzle {
    private final int MAX_MOVES = 2_000_000;

    final Set<Integer> closedNodes = new HashSet<>();
    private final Queue<Node> openNodes = new ArrayDeque<>();
    private Node target;

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
        return node.compareBoardTo(target.getBoard());
    }

    private void solve() {
        int moves = 0;

        while (moves < MAX_MOVES) {
            if (openNodes.isEmpty()) {
                break;
            }
            Node node = openNodes.remove();
            if (isTarget(node)) {
                System.out.println(node.getPath());
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
        startBoard.put(4, Color.BLUE);
        startBoard.put(5, Color.YELLOW);
        startBoard.put(6, Color.ORANGE);
        startBoard.put(7, Color.ORANGE);
        startBoard.put(8, Color.BLUE);
        startBoard.put(9, Color.ORANGE);
        startBoard.put(10, Color.BLUE);
        startBoard.put(11, Color.BLUE);
        startBoard.put(12, Color.YELLOW);
        startBoard.put(13, Color.BLUE);
        startBoard.put(14, Color.BLUE);
        startBoard.put(15, Color.YELLOW);
        startBoard.put(16, Color.BLUE);
        startBoard.put(17, Color.ORANGE);
        startBoard.put(18, Color.YELLOW);
        startBoard.put(19, Color.ORANGE);

        // test state
        /*startBoard.put(1, Color.ORANGE);
        startBoard.put(2, Color.BLUE);
        startBoard.put(3, Color.YELLOW);
        startBoard.put(4, Color.YELLOW);
        startBoard.put(5, Color.YELLOW);
        startBoard.put(6, Color.YELLOW);
        startBoard.put(7, Color.BLUE);
        startBoard.put(8, Color.BLUE);
        startBoard.put(9, Color.YELLOW);
        startBoard.put(10, Color.YELLOW);
        startBoard.put(11, Color.BLUE);
        startBoard.put(12, Color.YELLOW);
        startBoard.put(13, Color.ORANGE);
        startBoard.put(14, Color.ORANGE);
        startBoard.put(15, Color.BLUE);
        startBoard.put(16, Color.BLUE);
        startBoard.put(17, Color.ORANGE);
        startBoard.put(18, Color.ORANGE);
        startBoard.put(19, Color.BLUE);*/
        Node start = new Node(new ArrayList<>(), startBoard);
        openNodes.add(start);

        Map<Integer, Color> targetBoard = new HashMap<>();
        targetBoard.put(1, Color.YELLOW);
        targetBoard.put(2, Color.YELLOW);
        targetBoard.put(3, Color.YELLOW);
        targetBoard.put(4, Color.YELLOW);
        targetBoard.put(5, Color.ORANGE);
        targetBoard.put(6, Color.ORANGE);
        targetBoard.put(7, Color.ORANGE);
        targetBoard.put(8, Color.YELLOW);
        targetBoard.put(9, Color.ORANGE);
        targetBoard.put(10, Color.ORANGE);
        targetBoard.put(11, Color.YELLOW);
        targetBoard.put(12, Color.YELLOW);
        targetBoard.put(13, Color.BLUE);
        targetBoard.put(14, Color.BLUE);
        targetBoard.put(15, Color.BLUE);
        targetBoard.put(16, Color.BLUE);
        targetBoard.put(17, Color.BLUE);
        targetBoard.put(18, Color.BLUE);
        targetBoard.put(19, Color.BLUE);
        target = new Node(new ArrayList<>(), targetBoard);
    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        puzzle.init();
        puzzle.solve();
    }
}
