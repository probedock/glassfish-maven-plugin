package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Represents a connection factory configuration for its creation
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class ConnectionFactory implements Comparable<ConnectionFactory> {
	/**
	 * JNDI name of the connection factory
	 */
	@Parameter(required = true)
	private String jndiName;
	
	/**
	 * Which type of connection factory
	 */
	@Parameter(required = true)
	private Type type;

	/**
	 * An optional description
	 */
	@Parameter
	private String description;
	
	/**
	 * A user to set as a property
	 */
	@Parameter
	private String user;
	
	/**
	 * A password to set as a property
	 */
	@Parameter
	private String password;

	/**
	 * An address list to set as a property
	 */
	@Parameter
	private String addressList;
	
	/**
	 * A set of additional properties to configure
	 */
	@Parameter
	private Set<Property> properties;
	
	public String getJndiName() {
		return jndiName;
	}

	public Type getType() {
		return type;
	}

	public String getAddressList() {
		return addressList;
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	public String getDescription() {
		return description;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return
			"addressList=" + addressList + ", " +
			"description=" + description + ", " +
			"jndi=" + jndiName + ", " +
			"password=" + password  + ", " +
			"propeties=" + Stringifier.toString(properties) + ", " + 
			"type=" + type + ", " +
			"user=" + user + ", ";
	}

	@Override
	public int compareTo(ConnectionFactory connectionFactoryToCompare) {
		return jndiName.compareTo(connectionFactoryToCompare.jndiName);
	}
	
	/**
	 * Connection factory types
	 */
	public enum Type {
		CONNECTION_FACTORY("javax.jms.ConnectionFactory"),
    QUEUE_CONNECTION_FACTORY("javax.jms.QueueConnectionFactory"),
		TOPIC_CONNECTION_FACTORY("javax.jms.TopicConnectionFactory");

		private final String clazz;
		
		/**
		 * Constructor
		 * 
		 * @param clazz The class name of the connection factory
		 */
		private Type(String clazz) {
			this.clazz = clazz;
		}

		public String getClazz() {
			return clazz;
		}
	}
	
}
