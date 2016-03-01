package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Deploy application macro take care of the requirements (like domain created and started)
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DeployMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public DeployMacro(Configuration configuration) {
		super(configuration);

		// Take care of the domain operations if and only if the host is a local address
		if (isLocalDomain()) {
			// Check if the domain does not exist
			if (!configuration.getDomain().exists()) {
				registerCommand(new MacroMacroCommand(new CreateDomainMacro(configuration), "Creating domain."));
			}

			// Check if the domain is not started
			else if (!configuration.getDomain().isStarted()) {
				registerCommand(new MacroMacroCommand(new StartDomainMacro(configuration), "Starting domain."));
			}
		}
		
		registerCommand(new MacroCommand(buildDeployCommand(configuration), "Deploying application [" + configuration.getDeployConfiguration().getName() + "]."));
	}
}
