package com.atarhely.puzzle.launch;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class PuzzleJaxRsApplication extends Application {
	@Override
	public final Set<Object> getSingletons() {
		Set<Object> resources = new HashSet<>();
		resources.add(new PuzzleEndpoint());
		return resources;
	}
}
