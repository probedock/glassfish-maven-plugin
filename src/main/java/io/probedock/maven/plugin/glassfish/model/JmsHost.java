package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Represent the information for the hosts to add
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JmsHost implements Comparable<JmsHost> {
	@Parameter(required = true)
	private String name;
	
	@Parameter(required = true)
	private String mqHost;
	
	@Parameter
	private Integer mqPort;
	
	@Parameter
	private String mqUser;
	
	@Parameter
	private String mqPassword;
	
	@Parameter
	private Set<Property> properties;

	public String getMqHost() {
		return mqHost;
	}

	public String getName() {
		return name;
	}

	public String getMqPassword() {
		return mqPassword;
	}

	public Integer getMqPort() {
		return mqPort;
	}

	public boolean hasProperties() {
		return properties != null && !properties.isEmpty();
	}
	
	public Set<Property> getProperties() {
		return properties;
	}

	public String getMqUser() {
		return mqUser;
	}

	@Override
	public String toString() {
		return 
			"mqhost=" + mqHost + ", " +
			"mqpassword=" + mqPassword + ", " +
			"mqport=" + mqPort + ", " +
			"mquser=" + mqUser + ", " +
			"name=" + name + ", " + 
			"properties=" + Stringifier.toString(properties);
	}

	@Override
	public int compareTo(JmsHost jmsHostToCompare) {
		return name.compareTo(jmsHostToCompare.name);
	}
}
