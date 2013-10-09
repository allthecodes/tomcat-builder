package org.apache.tomcat.builder;

import org.apache.catalina.LifecycleException;
import org.junit.Test;

public class DefaultStartTest
{
	/**
	 * This test shows the simplest possible default way to startup a tomcat server with 
	 * an application deployed to it. The server will be configured exactly the same way 
	 * as if dowload tomcat zip file copy your war to the webapps and starutp with the default
	 * server.xml and startup.sh 
	 * 
	 * @throws LifecycleException
	 */
	@Test
	public void defaultStart() throws LifecycleException
	{
		DefaultServer server = new DefaultServer();
		server.deployAppDir("src/main/webapp", 7777).start();
	}

}
