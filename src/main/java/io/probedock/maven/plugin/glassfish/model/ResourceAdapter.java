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
	private String humanName;
	
	/**
	 * The deploy configuration for the resource adapter
	 */
	@Parameter(required = true)
	private DeployConfiguration deployConfig;
	
	/**
	 * A set of additional properties to configure
	 */
	@Parameter
	private Set<Property> properties;

	public String getHumanName() {
		return humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
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
	
	public DeployConfiguration getDeployConfig() {
		return deployConfig;
	}

	public void setDeployConfig(DeployConfiguration deployConfig) {
		this.deployConfig = deployConfig;
	}

	@Override
	public String toString() {
		return 
			"humanName=" + humanName + ", " +
			"deployConfig=" + deployConfig + ", " +
			"properties=" + Stringifier.toString(properties);
	}

	@Override
	public int compareTo(ResourceAdapter resourceAdapterToCompare) {
		return humanName.compareTo(resourceAdapterToCompare.humanName);
	}
}
