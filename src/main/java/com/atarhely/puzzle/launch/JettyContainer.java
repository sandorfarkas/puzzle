package com.atarhely.puzzle.launch;

import javax.ws.rs.core.Application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyContextParameters;

public class JettyContainer {
	private static final int PRIORITY_ONE = 1;
	private final Server server;
	
	public JettyContainer(int port, Class<? extends Application> applicationClass) {
		server = new Server(port);
		server.setHandler(createServletContextHandler(applicationClass));
	}
	
	private ServletContextHandler createServletContextHandler(Class<? extends Application> applicationClass) {
		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletContextHandler.addServlet(createBackendServletHolder(applicationClass), "/api/*");
		return servletContextHandler;
	}
	
	private static ServletHolder createBackendServletHolder(Class<? extends Application> applicationClass) {
		ServletHolder servletHolder = new ServletHolder(HttpServletDispatcher.class);
		servletHolder.setInitParameter("javax.ws.rs.Application", applicationClass.getName());
		servletHolder.setInitParameter(ResteasyContextParameters.RESTEASY_SERVLET_MAPPING_PREFIX, "/api");
		return servletHolder;
	}
	
	public void start() {
		try {
			server.start();
			server.join();
		}
		catch (Exception e) {
			throw new RuntimeException("Exception while starting Jetty server", e);
		}
	}
	
	public static Builder builder(Class<? extends Application> applicationClass) {
		return new Builder(applicationClass);
	}
	
	public static class Builder {
		private static final int DEFAULT_PORT = 8080;
		private int port = DEFAULT_PORT;
		private Class<? extends Application> applicationClass;
		
		public Builder(Class<? extends Application> applicationClass) {
			this.applicationClass = applicationClass;
		}
		
		public JettyContainer build() {
			return new JettyContainer(port, applicationClass);
		}
		
		@SuppressWarnings("hiding")
		public Builder withPort(int port) {
			this.port = port;
			return this;
		}
	}
}
