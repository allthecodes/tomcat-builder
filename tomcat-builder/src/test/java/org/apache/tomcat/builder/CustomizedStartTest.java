package org.apache.tomcat.builder;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.junit.Test;

public class CustomizedStartTest {
	
	/**
	 * This test should show different aspect of server.xml can be configured within this api.
	 * 
	 * @throws LifecycleException
	 */
	@Test
	public void exampleStart() throws LifecycleException
	{
		ServerBuilder serverBuilder = new ServerBuilder();
		serverBuilder.jspOn().shutdownPort(8006).shutdownString("shutdown");
		Server server = serverBuilder.build();
		server.start();
		server.await();
	}
}
