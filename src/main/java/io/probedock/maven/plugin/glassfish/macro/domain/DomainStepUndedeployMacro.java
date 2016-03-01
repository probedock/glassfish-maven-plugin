package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.*;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;
import io.probedock.maven.plugin.glassfish.model.UndeployConfiguration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Manage the undeploy macro for a domain step creation.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DomainStepUndedeployMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 * @param undeployConfiguration The undeploy configuration
	 */
	public DomainStepUndedeployMacro(Configuration configuration, DomainCreationStep domainCreationStep, UndeployConfiguration undeployConfiguration) {
		super(configuration, domainCreationStep);

		// Check if the domain does not exist
		if (configuration.getDomain().exists()) {
			registerCommand(new MacroCommand(buildUndeployCommand(configuration, undeployConfiguration), "Undeploying application + [" + undeployConfiguration.getName() + "]."));	
		}
	}
}
