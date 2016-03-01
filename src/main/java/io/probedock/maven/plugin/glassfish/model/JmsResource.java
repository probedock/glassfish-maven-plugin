package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * A JMS resource configuration. See the ASADMIN help to have more
 * information of the properties you can configure.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JmsResource implements Comparable<JmsResource> {
	@Parameter(required = true)
	private String jndiName;
	
	@Parameter(required = true)
	private Type type;

	@Parameter
	private String name;
	
	@Parameter
	private String description;
	
	@Parameter(defaultValue = "false")
	private boolean createPhysicalDestination = false;
	
	@Parameter
	private Set<Property> properties;
	
	public String getJndiName() {
		return jndiName;
	}

	public Type getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public boolean isCreatePhysicalDestination() {
		return createPhysicalDestination;
	}
	
	@Override
	public String toString() {
		return
			"createPhysicalDestination=" + createPhysicalDestination + ", " +
			"description=" + description + ", " +
			"jndi=" + jndiName + ", " +
			"name=" + name + ", " +
			"propeties=" + Stringifier.toString(properties) + ", " + 
			"type=" + type + ", ";
	}

	@Override
	public int compareTo(JmsResource jmsResourceToCompare) {
		return jndiName.compareTo(jmsResourceToCompare.jndiName);
	}
	
	/**
	 * Connection factory types
	 */
	public enum Type {
		QUEUE("javax.jms.Queue"),
		TOPIC("javax.jms.Topic");

		private String clazz;
		
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
