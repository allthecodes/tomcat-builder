Tomcat Builder Proposal: 

This proposal outlines a design for an API that will make embedding tomcat easy without sacrificing the ability to customize the tomcat configuration as provided by server.xml and files in /conf.

You are probably thinking that we already have Tomcat.class for making embedding easier. So lets us start out with a list of some of current limitations of the Tomcat class.

*	There are many settings that are easy to configure in server.xml which are not easy or not possible to configure with Tomcat.class
*	Configuring multiple connectors 
*	Add valves
*	Configuring a cluster
*	Defining Resources such as DataSources / Mail Sessions
* Setting a default web.xml for tomcat
* Setting the properties found in catalina.properties 
* Bottom line is that when you want to embed tomcat with a production like custom configuration the current tomcat class does not provide enough apis to make it possible to do what you want. 

What I am proposing is a new embedding API under org.apache.tomcat.builder that will provide an embedding api with the following goals.

* Everything that can be configured via server.xml, or catalina.properties or any file found in /conf folder can be configured via the tomcat builder api. As a user I can be 100% confident that I can programmatically control every aspect of tomcat. 
* The API builds on the existing structure of the xml configuration and the existing documentation. Someone who knows how to do something with configuration files should be able to correctly guess how to do the same thing with the embedding API without having to read the Java doc or  sample code. 
* The reference documentation for tomcat configuration should be applicable to the embedding api so that existing documentation does not need to be updated and can just be reused. 
* There are two extremes to using the API which the API should accommodate
* One liner start that allows a default configuration of tomcat to be started with a single line of java code 
* Total control start where every aspect of the configuration is customized / set


Proposed Design: 
*	A fluent API that mirrors the major objects exposed via the XML elements example objects are 
  *	ServerBuilder 
  *	ServiceConfiguration
  *	EngineConfiguration
  *	ContextConfiguration
  *	ValveConfiguration
  * ResourceConfiguration
  * ConnectorConfiguration 
  * …. Etc 

*	The fluent API will make it possible to build a graph of the configuration objects quickly & easily then call a build() method to get the configured Server object that can be started. 
*	A DefaultServerConfiguration class that provides the ability to start tomcat with one line call using default settings as configured in the default server.xml that ships with tomcat.
*	The API will be implemented for both Tomcat 7 and Tomcat 8
*	The API will just work on top on an existing build you should be bale to drop a tomcat-builder.jar into CATALINA_HOME\lib and have it be available
*	The existing Tomcat class will not be touched. 

Code Repo: 

https://github.com/asaikali/tomcat-builder contains a very early version of this API it is just work in progress but there is enough there to ask for feedback and give you a better idea of what I am thinking.
	

What I am looking for are answers to the following questions.

* Has anyone already done such as API?
*	Do Tomcat committer want such embedding features added to tomcat?
*	Is there still time to include such an API in tomcat 8?
* Is there any chance that such a jar would be included in the core tomcat 7 distribution? 

If you are wondering why as a user why you want to embed tomcat please refer to my slides on this topic from. 
*	Java One 2013 - https://bitbucket.org/asaikali/javaone-tomcat-embedding
* Toronto JUG - https://bitbucket.org/asaikali/tjug-tomcat-embedding
