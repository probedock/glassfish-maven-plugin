package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Represents an admin object and configuration required for its creation.
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class AdminObject implements Comparable<AdminObject> {

	/**
	 * JNDI name of the admin object
	 */
	@Parameter(required = true)
	private String jndiName;
	
	/**
	 * Name of the resource adapter to use
	 */
	@Parameter(required = true)
	private String raname;
	
	/**
	 * Type (class name) of the resource
	 */
	@Parameter(required = true)
	private String resourceType;
	
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

	public String getRestype() {
		return resourceType;
	}

	public void setRestype(String restype) {
		this.resourceType = restype;
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
			"raname=" + raname + "," +
			"resourceType=" + resourceType + "," +
			"properties=" + Stringifier.toString(properties);
	}

	@Override
	public int compareTo(AdminObject adminObjectToCompare) {
		return jndiName.compareTo(adminObjectToCompare.jndiName);
	}
}
