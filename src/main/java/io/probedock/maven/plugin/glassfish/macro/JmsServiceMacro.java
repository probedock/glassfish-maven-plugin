package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.Property;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * This macro command configure the JMS Service on glassfish server
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JmsServiceMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public JmsServiceMacro(Configuration configuration) {
		super(configuration);

		// Configure the JMS Service
		if (configuration.getGlassfish().getJmsService() != null && configuration.getGlassfish().getJmsService().hasProperties()) {
			for (Property property : configuration.getGlassfish().getJmsService().getProperties()) {
				// Create and register the command
				registerCommand(
					new MacroCommand(
						buildSetJmsServiceAttributeCommand(configuration, property), 
						"Set the JMS service attribute [" + property.getName() + "]."
					)
				);
			}
		}
	}		
}
