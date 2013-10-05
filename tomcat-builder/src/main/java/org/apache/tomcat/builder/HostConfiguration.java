package org.apache.tomcat.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Host;
import org.apache.catalina.core.StandardHost;

public class HostConfiguration
{
	private List<ContextConfiguration> contexts = new ArrayList<>();
	
	private String appBase; 
	private String xmlBase; 
	private boolean createDirs;
	private boolean autoDeploy;
	private int backgroundProcessorDelay;
	
	public Host build()
	{
		StandardHost host = new StandardHost();
		host.setName("localhost");
		return null;
	}

	public HostConfiguration addContext(ContextConfiguration contextConfiguration)
	{
		this.contexts.add(contextConfiguration);
		return this; 
	}
	
	public String getAppBase()
	{
		return appBase;
	}


	public HostConfiguration setAppBase(String appBase)
	{
		this.appBase = appBase;
		return this;
	}


	public String getXmlBase()
	{
		return xmlBase;
	}


	public HostConfiguration setXmlBase(String xmlBase)
	{
		this.xmlBase = xmlBase;
		return this;
	}


	public boolean isCreateDirs()
	{
		return createDirs;
	}


	public HostConfiguration setCreateDirs(boolean createDirs)
	{
		this.createDirs = createDirs;
		return this;
	}


	public boolean isAutoDeploy()
	{
		return autoDeploy;
	}


	public HostConfiguration setAutoDeploy(boolean autoDeploy)
	{
		this.autoDeploy = autoDeploy;
		return this;
	}


	public int getBackgroundProcessorDelay()
	{
		return backgroundProcessorDelay;
	}


	public HostConfiguration setBackgroundProcessorDelay(int backgroundProcessorDelay)
	{
		this.backgroundProcessorDelay = backgroundProcessorDelay;
		return this;
	}


	public List<ContextConfiguration> getContexts()
	{
		return contexts;
	}


	public void setContexts(List<ContextConfiguration> contexts)
	{
		this.contexts = contexts;
	}

}
