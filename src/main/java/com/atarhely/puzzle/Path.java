package com.atarhely.puzzle;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import com.atarhely.puzzle.board.Operation;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Path {
	public static final Path GENESIS_PATH = new Path(new ArrayList<>());
	
	private final List<Operation> stepsInPath;
	
	Path getCopyWithStepAdded(Operation operationStep) {
		List<Operation> newStepsInPath = new ArrayList<>(stepsInPath);
		newStepsInPath.add(operationStep);
		
		return new Path(newStepsInPath);
	}
	
	public int numberOfSteps() {
		return stepsInPath.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Operation step : stepsInPath) {
			sb.append(step).append(System.lineSeparator());
		}
		return sb.toString();
	}
}
