package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Represents a connector resource and configuration required for its creation.
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class ConnectorResource implements Comparable<ConnectorResource> {

	/**
	 * JNDI name of the connector resource
	 */
	@Parameter(required = true)
	private String jndiName;
	
	/**
	 * Name of the referenced connector connection pool name
	 */
	@Parameter(required = true)
	private String poolName;
	
	@Parameter
	private Set<Property> properties;

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return 
			"jndiName=" + jndiName + ", " +
			"poolName=" + poolName  + ", " +
			"properties=" + Stringifier.toString(properties);
	}

	@Override
	public int compareTo(ConnectorResource connectorResourceToCompare) {
		return jndiName.compareTo(connectorResourceToCompare.jndiName);
	}
	
}
