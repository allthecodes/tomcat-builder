package org.apache.tomcat.builder;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;

public class DefaultServer
{
	private Server server; 
	
	public DefaultServer deployAppDir(String appDir)
	{
		return this;
	}
	
	public DefaultServer deployAppDir(String appDir, int port)
	{
		return this;
	}
	
	public void start() throws LifecycleException
	{
		ServerBuilder serverBuilder = new ServerBuilder();
		server = serverBuilder.build();
		server.start();
		server.await();		
	}
	
	public void stop() throws LifecycleException
	{
		server.stop();
	}
	
}
