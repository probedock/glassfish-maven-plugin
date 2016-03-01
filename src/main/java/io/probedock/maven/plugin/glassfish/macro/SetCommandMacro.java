package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

import io.probedock.maven.plugin.glassfish.model.Property;

/**
 * This macro take care of creating set configuration for a domain
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class SetCommandMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public SetCommandMacro(Configuration configuration) {
		super(configuration);

		if (configuration.getDomain().getProperties() != null) {
			for (Property property : configuration.getDomain().getProperties()) {
				registerCommand(new MacroCommand(buildSetCommand(configuration, property), "Setting domain property: " + property.getName()));
			}
		}
  }
}
