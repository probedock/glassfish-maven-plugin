package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Configuration for a resource adapter.
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class ResourceAdapter implements Comparable<ResourceAdapter> {
	@Parameter(required = true)
	private String name;
	
	/**
	 * A set of additional properties to configure
	 */
	@Parameter
	private Set<Property> properties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}
	
	public boolean hasProperties() {
		return this.properties != null && !this.properties.isEmpty();
	}
	
	@Override
	public String toString() {
		return 
			"name=" + name + ", " +
			"properties=" + Stringifier.toString(properties);
	}

	@Override
	public int compareTo(ResourceAdapter resourceAdapterToCompare) {
		return name.compareTo(resourceAdapterToCompare.name);
	}
}
