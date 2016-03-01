package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DeployConfiguration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Manage the deployment for a domain step creation.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DomainStepDeployMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 * @param deployConfiguration The deployment configuration
	 */
	public DomainStepDeployMacro(Configuration configuration, DomainCreationStep domainCreationStep, DeployConfiguration deployConfiguration) {
		super(configuration, domainCreationStep);
		registerCommand(new MacroCommand(buildDeployCommand(configuration, deployConfiguration), "Deploying application [" + deployConfiguration.getName() + "]."));
	}
}
