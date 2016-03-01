package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Represents a connector connection pool and configuration required its creation.
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class ConnectorConnectionPool implements Comparable<ConnectorConnectionPool> {

	/**
	 * JNDI name of the connector connector pool
	 */
	@Parameter(required = true)
	private String jndiName;
	
	/**
	 * Name of the resource adapter
	 */
	@Parameter(required = true)
	private String raname;
	
	/**
	 * The name of the connection definition
	 */
	@Parameter(required = true)
	private String connectionDefinition;
	
	/**
	 * Ping during creation of the connection pool
	 */
	@Parameter(defaultValue = "true")
	private Boolean ping = true;
	
	/**
	 * Ping during creation of the connection pool
	 */
	@Parameter(defaultValue = "true")
	private Boolean isConnectValidateReq = true;
	
	@Parameter
	private Set<Property> properties;

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getRaname() {
		return raname;
	}

	public void setRaname(String raname) {
		this.raname = raname;
	}

	public String getConnectionDefinition() {
		return connectionDefinition;
	}

	public void setConnectionDefinition(String connectionDefinition) {
		this.connectionDefinition = connectionDefinition;
	}

	public Boolean getPing() {
		return ping;
	}

	public void setPing(Boolean ping) {
		this.ping = ping;
	}

	public Boolean getIsConnectValidateReq() {
		return isConnectValidateReq;
	}

	public void setIsConnectValidateReq(Boolean isConnectValidateReq) {
		this.isConnectValidateReq = isConnectValidateReq;
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
			"connectionDefinition=" + connectionDefinition + ", " + 
			"isConnectValidateReq=" + isConnectValidateReq + ", " +
			"jndiName=" + jndiName + ", " +
			"ping=" + ping + ", " +
			"properties=" + Stringifier.toString(properties) + ", " +
			"raname=" + raname;
	}

	@Override
	public int compareTo(ConnectorConnectionPool connectorConnectionPoolToCompare) {
		return jndiName.compareTo(connectorConnectionPoolToCompare.jndiName);
	}
}
