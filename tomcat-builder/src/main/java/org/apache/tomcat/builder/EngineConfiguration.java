package org.apache.tomcat.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Host;
import org.apache.catalina.core.StandardEngine;

public class EngineConfiguration
{
	private String name = "Engine";
	private String defaultHost = "localhost";
	private String baseDir;
	private int backgroundProcessorDelay = 10;
	private int startStopThreads = 10;
	private String jvmRoute;

	private List<HostConfiguration> hosts = new ArrayList<>();

	StandardEngine build()
	{
		StandardEngine engine = new StandardEngine();
		engine.setName(name);
		engine.setDefaultHost(defaultHost);
		engine.setBaseDir(baseDir);
		engine.setBackgroundProcessorDelay(backgroundProcessorDelay);
		engine.setStartStopThreads(startStopThreads);
		engine.setJvmRoute(jvmRoute);

		for (HostConfiguration hostConfiguration : hosts)
		{
			Host host = hostConfiguration.build();
			engine.addChild(host);
		}

		return engine;
	}
	
	public HostConfiguration getDefaultHostConfiguration()
	{
		return hosts.get(0);
	}

	public String getName()
	{
		return name;
	}

	public EngineConfiguration setName(String name)
	{
		this.name = name;
		return this;
	}

	public EngineConfiguration addHost(HostConfiguration hostConfiguration)
	{
		this.hosts.add(hostConfiguration);
		return this;
	}

	public String getDefaultHost()
	{
		return defaultHost;
	}

	public EngineConfiguration setDefaultHost(String defaultHost)
	{
		this.defaultHost = defaultHost;
		return this;
	}

	public int getBackgroundProcessorDelay()
	{
		return backgroundProcessorDelay;
	}

	public EngineConfiguration setBackgroundProcessorDelay(int backgroundProcessorDelay)
	{
		this.backgroundProcessorDelay = backgroundProcessorDelay;
		return this;
	}

	public int getStartStopThreads()
	{
		return startStopThreads;
	}

	public EngineConfiguration setStartStopThreads(int startStopThreads)
	{
		this.startStopThreads = startStopThreads;
		return this;
	}

	public String getJvmRoute()
	{
		return jvmRoute;
	}

	public EngineConfiguration setJvmRoute(String jvmRoute)
	{
		this.jvmRoute = jvmRoute;
		return this;
	}
}
