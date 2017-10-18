package com.atarhely.puzzle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class Node {
    @Getter private final List<Integer> path;
    @Getter private final Map<Integer, Color> board;

    public List<Integer> getPathCopy() {
        List<Integer> copiedPath = new ArrayList<>();
        copiedPath.addAll(path);
        return copiedPath;
    }

    public Map<Integer, Color> getBoardCopy() {
        Map<Integer, Color> copiedBoard = new HashMap<>();
        board.entrySet().stream()
                .forEach(map -> copiedBoard.put(map.getKey(), map.getValue()));
        return copiedBoard;
    }

    public boolean compareBoardTo(Map<Integer, Color> board) {
        return this.board.equals(board);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return board != null ? board.equals(node.board) : node.board == null;
    }

    @Override
    public int hashCode() {
        String hash = "" + board.get(1).ordinal()
                + board.get(1).ordinal()
                + board.get(2).ordinal()
                + board.get(3).ordinal()
                + board.get(4).ordinal()
                + board.get(5).ordinal()
                + board.get(6).ordinal()
                + board.get(7).ordinal()
                + board.get(8).ordinal()
                + board.get(9).ordinal()
                + board.get(10).ordinal()
                + board.get(11).ordinal()
                + board.get(12).ordinal()
                + board.get(13).ordinal()
                + board.get(14).ordinal()
                + board.get(15).ordinal()
                + board.get(16).ordinal()
                + board.get(17).ordinal()
                + board.get(18).ordinal()
                + board.get(19).ordinal();
        return board != null ? hash.hashCode() : 0;
    }
}
