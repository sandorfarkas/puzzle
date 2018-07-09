package com.atarhely.puzzle;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Path {
	static final Path GENESIS_PATH = new Path(new ArrayList<>());
	
	private final List<Integer> stepsInPath;
	
	Path getCopyWithStepAdded(Integer step) {
		List<Integer> newStepsInPath = new ArrayList<>(stepsInPath);
		newStepsInPath.add(step);
		
		return new Path(newStepsInPath);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Integer i : stepsInPath) {
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
}
