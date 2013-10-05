package org.apache.tomcat.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardService;

public class ServiceConfiguration
{
	private String name; 
	private EngineConfiguration engineConfiguration; 
	private List<ConnectorConfiguration> connectors = new ArrayList<>();
	public ServiceConfiguration name(String name)
	{
		this.setName(name); 
		return this; 
	}
	
	
	public ServiceConfiguration addConnector(ConnectorConfiguration connector)
	{
		this.connectors.add(connector);
		return this;
	}


	public String getName()
	{
		return name;
	}


	public ServiceConfiguration setName(String name)
	{
		this.name = name;
		return this; 
	}
	
	Service build()
	{

		Service service = new StandardService();
		service.setName(name);	
		
		for (ConnectorConfiguration connectorConfiguration : connectors)
		{
			Connector connector = connectorConfiguration.build();
			service.addConnector(connector);
		}
		
		return service; 
	}


	public EngineConfiguration getEngineConfiguration()
	{
		return engineConfiguration;
	}


	public ServiceConfiguration setEngineConfiguration(EngineConfiguration engineConfiguration)
	{
		this.engineConfiguration = engineConfiguration;
		return this; 
	}

}
