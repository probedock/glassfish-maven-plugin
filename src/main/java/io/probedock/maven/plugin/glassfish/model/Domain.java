package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * The domain configuration
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class Domain {
	/**
	 * The target host
	 */
	@Parameter
	private String host;
	
	/**
	 * The directory in which this domain should be created (if other than the Glassfish default). Overrides the value of domainDirectory in global configuration.
	 * This value is ignored if the host is other than localhost.
	 */
	@Parameter(defaultValue = "${glassfish.home}/domains")
	private File directory;
	
	/**
	 * The name of the domain (will be used as directory name)
	 */
	@Parameter(required = true)
	private String name;

	/**
	 * The administration port
	 */
	@Parameter(required = true)
	private int adminPort;
	
	/**
	 * The HTTP port (instance port)
	 */
	@Parameter
	private int httpPort;
	
	/**
	 * The HTTPS port
	 */
	@Parameter
	private int httpsPort;
	
	/**
	 * The IIOP port
	 */
	@Parameter
	private int iiopPort;
	
	/**
	 * The IIOP SSL port
	 */
	@Parameter
	private int iiopsPort;
	
	/**
	 * The IIOP SSL MutualAuth port
	 */
	@Parameter
	private int iiopsmPort;
	
	/**
	 * The JMS port
	 */
	@Parameter
	private int jmsPort;
	
	/**
	 * The JMX port
	 */
	@Parameter
	private int jmxPort;
	
	/**
	 * The Debugger port
	 */
	@Parameter
	private int debuggerPort;
	
	/**
	 * The OSGI Shell Telnet port
	 */
	@Parameter
	private int osgiShellTelnetPort;
	
	/**
	 * Decide if a domain can be reused or not
	 */
	@Parameter(defaultValue = "false")
	private boolean reuse;
	
	/**
	 * Define the properties to set for the logging configuration
	 */
	@Parameter
	private Set<Property> loggingAttributes;
	
	/**
	 * Define the various step to configure a domain
	 */
	@Parameter(required = true)
	DomainCreationStep[] creationSteps;
	
	public String getName() {
		return name;
	}

	public int getAdminPort() {
		return adminPort;
	}

	public int getHttpPort() {
		return httpPort;
	}

	public int getHttpsPort() {
		return httpsPort;
	}

	public int getIiopPort() {
		return iiopPort;
	}

	public int getIiopsPort() {
		return iiopsPort;
	}

	public int getIiopsmPort() {
		return iiopsmPort;
	}

	public int getJmsPort() {
		return jmsPort;
	}

	public int getJmxPort() {
		return jmxPort;
	}

	public int getDebuggerPort() {
		return debuggerPort;
	}

	public int getOsgiShellTelnetPort() {
		return osgiShellTelnetPort;
	}

	public boolean isReuse() {
		return reuse;
	}

	public Set<Property> getLoggingAttributes() {
		return loggingAttributes;
	}
	
	/**
	 * @return True if the domain exists (if the directory of the domain exists)
	 */
	public boolean exists() {
		return (host == null || "localhost".equals(host)) ? directory.exists() && Arrays.asList(directory.list()).contains(name) : false;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public DomainCreationStep[] getCreationSteps() {
		return creationSteps;
	}

	public void setCreationSteps(DomainCreationStep[] creationSteps) {
		this.creationSteps = creationSteps;
	}
	
	/**
	 * @return True if the admin port respond to a socket solicitation
	 */
	public boolean isStarted() {
		try {
			Socket socket = new Socket(host, adminPort);
			socket.close();
			return true;
		}
		catch (IOException e) {
			return false;
		}
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	@Override
	public String toString() {
		return 
			"adminPort=" + adminPort + ", " + 
			"creationSteps=" + Stringifier.toString(creationSteps) + ", " +
			"debuggerPort=" + debuggerPort + ", " +
			"directory=" + directory + ", " + 
			"host=" + host + ", " + 
			"httpPort=" + httpPort + ", " +
			"httpsPort=" + httpsPort + ", " + 
			"iiopPort=" + iiopPort + ", " +
			"iiopsPort=" + iiopsPort + ", " +
			"iipsmPort=" + iiopsmPort + ", " +
			"jmsPort=" + jmsPort + ", " + 
			"jmxPort=" + jmxPort + ", " + 
			"loggingAttributes=" + Stringifier.toString(loggingAttributes) + ", " +
			"name=" + name + ", " + 
			"reuse=" + reuse;
	}
}
