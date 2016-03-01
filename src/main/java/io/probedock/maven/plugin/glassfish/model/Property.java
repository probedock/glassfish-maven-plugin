package io.probedock.maven.plugin.glassfish.model;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * A property configuration
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class Property implements Comparable<Property> {
	@Parameter(required = true)
	private String name;

	@Parameter(required = true)
	private String value;

	/**
	 * Constructor
	 */
	public Property() {}

	/**
	 * Constructor
	 * 
	 * @param name A name
	 * @param value A value
	 */
	public Property(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return 
			"name=" + name + ", " +
			"value=" + value;
	}

	@Override
	public int compareTo(Property propertyToCompare) {
		if (name == null) {
			return -1;
		} else if (propertyToCompare.name == null) {
			return 1;
		}

		int result = name.compareTo(propertyToCompare.name);

		if (result == 0) {
			if (value == null) {
				return -1;
			} else if (propertyToCompare.value == null) {
				return 1;
			}

			return value.compareTo(propertyToCompare.value);
		} else {
			return result;
		}
	}
}
