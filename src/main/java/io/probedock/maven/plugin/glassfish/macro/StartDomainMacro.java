package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * The start domain macro organize the different commands to run depending the situation
 * of the domain to start (is it created, is it existed, ...) and the configuration of the
 * plugin.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class StartDomainMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public StartDomainMacro(Configuration configuration) {
		super(configuration);

		if (isLocalDomain()) {
			throw new UnsupportedOperationException("Starting a domain on a remote host is not supported yet.");
		}
		
		// Check if the domain exists
		if (!configuration.getDomain().exists()) {
			// Check if the domain can be created automatically
			if (configuration.getGlassfish().isAutoCreate()) {
				registerCommand(new MacroCommand(buildCreateDomainCommand(configuration), "Domain does not exist. Creating it for you."));
			}
			
			// Conflict in the configuration
			else {
				throw new IllegalStateException("Domain does not exist and [autoCreate] is [false]. Try 'mvn glassfish:createDomain' first.");
			}
		}
		
		registerCommand(new MacroCommand(buildStartDomainCommand(configuration), "Starting the domain."));
  }
}
