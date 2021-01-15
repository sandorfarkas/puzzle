package com.atarhely.puzzle.launch;

public class Main {
	public static void main(String[] args) {
		JettyContainer.builder(PuzzleJaxRsApplication.class)
				.withPort(8888)
				.build()
				.start();
	}
}
