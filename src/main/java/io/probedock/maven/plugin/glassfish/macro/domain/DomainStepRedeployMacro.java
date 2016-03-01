package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.*;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;
import io.probedock.maven.plugin.glassfish.model.RedeployConfiguration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Manage a redeploy macro for a domain step creation.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DomainStepRedeployMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 * @param redeployConfiguration The redeployment configuration
	 */
	public DomainStepRedeployMacro(Configuration configuration, DomainCreationStep domainCreationStep, RedeployConfiguration redeployConfiguration) {
		super(configuration, domainCreationStep);
		registerCommand(new MacroCommand(buildRedeployCommand(configuration, redeployConfiguration), "Deploying application [" + redeployConfiguration.getName() + "]."));
	}
}
