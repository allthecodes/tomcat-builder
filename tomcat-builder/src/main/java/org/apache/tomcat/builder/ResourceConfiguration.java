package org.apache.tomcat.builder;

public class ResourceConfiguration
{
	private String className;

	public String getClassName()
	{
		return className;
	}

	public ResourceConfiguration setClassName(String className)
	{
		this.className = className;
		return this;
	}
}
