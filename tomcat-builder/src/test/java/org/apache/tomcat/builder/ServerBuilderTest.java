package org.apache.tomcat.builder;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.junit.Test;

public class ServerBuilderTest {
	
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
