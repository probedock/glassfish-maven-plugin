package io.probedock.maven.plugin.glassfish.model;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * The un-deployment configuration of an application
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class UndeployConfiguration {
	@Parameter(required = true)
	private String name;

	@Parameter
	private Boolean dropTables;
	
	@Parameter
	private Boolean cascade;
	
	public Boolean getDropTables() {
		return dropTables;
	}

	public Boolean getCascade() {
		return cascade;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return 
			"cascade=" + cascade + ", " + 
			"dropTables=" + dropTables + ", " +
			"name=" + name;
	}
}
