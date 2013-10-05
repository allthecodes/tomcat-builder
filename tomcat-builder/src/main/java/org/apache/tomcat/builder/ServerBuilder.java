package org.apache.tomcat.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.core.JasperListener;
import org.apache.catalina.core.StandardServer;

/**
 * Design goals:
 * 
 * 1. you should not have to know the internal tomcat classes to use this 2. should not have to read the java doc to figure out what to do
 * 3. you should be able to use your knowledge of server.xml to configure this 4. you should be able to control every setting that you can
 * control in server.xml easily 5. existing reference docs should apply
 * 
 * @author Adib Saikali
 * 
 */
public class ServerBuilder
{
	private int shutdownPort = 8080;
	private String shutdownString = "SHUTDOWN";
	private boolean enableJSP = true;
	private List<ServiceConfiguration> services = new ArrayList<>();
	private List<String> listenerClassNames = new ArrayList<>();
	
	public ServerBuilder shutdownPort(int port)
	{
		this.shutdownPort = port;
		return this;
	}

	public ServerBuilder shutdownString(String shutdownString)
	{
		this.shutdownString = shutdownString;
		return this;
	}

	public ServerBuilder jspOn()
	{
		this.enableJSP = true;
		return this;
	}

	public ServerBuilder jspOff()
	{
		this.enableJSP = false;
		return this;
	}

	public ServerBuilder addService(ServiceConfiguration serviceConfiguration)
	{
		this.services.add(serviceConfiguration);
		return this;
	}
	
	public ServerBuilder addListener(String className){
		this.listenerClassNames.add(className);
		return this; 
	}

	public Server build()
	{

		Server server = new StandardServer();
		server.setPort(shutdownPort);
		server.setShutdown(shutdownString);
		if (enableJSP)
		{
			server.addLifecycleListener(new JasperListener());
		}

		for (ServiceConfiguration serviceConfiguration : services)
		{
			Service service = serviceConfiguration.build();
			server.addService(service);
		}

		return server;
	}

}
