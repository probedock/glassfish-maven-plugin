package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

import io.probedock.maven.plugin.glassfish.model.JmsHost;
import io.probedock.maven.plugin.glassfish.model.Property;

/**
 * This macro command configure the JMS Hosts on glassfish server
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JmsHostsMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public JmsHostsMacro(Configuration configuration) {
		super(configuration);

		// Delete the default JMS host
		if (configuration.getGlassfish().isDeleteDefaultJmsHost()) {
			registerCommand(new MacroCommand(buildDeleteDefaultJmsHost(configuration), "Delete the default JMS Host."));
		}
		
		// Configure the JMS Hosts if there are some
		if (configuration.getGlassfish().hasJmsHosts()) {
			for (JmsHost jmsHost : configuration.getGlassfish().getJmsHosts()) {
				// Create and register the command
				registerCommand(new MacroCommand(buildCreateJmsHostCommand(configuration, jmsHost), "Create the JMS Host [" + jmsHost.getName() + "]."));
				
				// Check if there are properties for the host
				if (jmsHost.hasProperties()) {
					for (Property property : jmsHost.getProperties()) {
						// Create and register the command
						registerCommand(
							new MacroCommand(
								buildSetJmsHostAttributeCommand(configuration, jmsHost, property), 
								"Set the JMS Host [" + jmsHost.getName() + "] attribute [" + property.getName() + "]."
							)
						);
					}
				}
			}
		}
	}
}
