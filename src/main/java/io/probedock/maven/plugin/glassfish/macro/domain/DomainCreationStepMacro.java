package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroMacroCommand;
import io.probedock.maven.plugin.glassfish.macro.RestartDomainMacro;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DeployConfiguration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;
import io.probedock.maven.plugin.glassfish.model.RedeployConfiguration;
import io.probedock.maven.plugin.glassfish.model.UndeployConfiguration;

/**
 * Creation step macro to create a domain in a multi step way
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DomainCreationStepMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCrationStep The current step to create the domain
	 */
	public DomainCreationStepMacro(Configuration configuration, DomainCreationStep domainCrationStep) {
		super(configuration, domainCrationStep);
		
		if (currentDomainCreationStep.isRestartBefore()) {
			registerCommand(new MacroMacroCommand(new RestartDomainMacro(configuration), "Restart the domain before the creation step."));
		}

		// Configure the JVM options for the domain. It will removes and add JVM options.
		registerCommand(new MacroMacroCommand(new JvmOptionsMacro(configuration, currentDomainCreationStep), "Managing the JVM options."));
		
		// Configure additional domain properties
		registerCommand(new MacroMacroCommand(new SetCommandMacro(configuration, currentDomainCreationStep), "Setting additional domain properties"));
		
		// Configure the JMS resources
		registerCommand(new MacroMacroCommand(new JmsResourcesMacro(configuration, currentDomainCreationStep), "Managing JMS Resources."));
		
		// Configure the JDBC resources
		registerCommand(new MacroMacroCommand(new JdbcResourcesMacro(configuration, currentDomainCreationStep), "Managing JDBC Resources."));
		
		// Configure the resource adapters
		registerCommand(new MacroMacroCommand(new ResourceAdaptersMacro(configuration, currentDomainCreationStep), "Managing Resource Adapters"));
		
		// Configure the connector connection pools
		registerCommand(new MacroMacroCommand(new ConnectorConnectionPoolsMacro(configuration, currentDomainCreationStep), "Managing Connector Connection Pools."));
		
		// Configure the connector resources
		registerCommand(new MacroMacroCommand(new ConnectorResourceMacro(configuration, currentDomainCreationStep), "Managing Connector Resources."));
		
		// Configure the admin objects
		registerCommand(new MacroMacroCommand(new AdminObjectsMacro(configuration, currentDomainCreationStep), "Managing Admin Objects."));
		
		// Manage the deploy commands
		if (currentDomainCreationStep.hasDeployConfigurations()) {
			for (DeployConfiguration dc : currentDomainCreationStep.getDeployConfigurations()) {
				registerCommand(new MacroMacroCommand(new DomainStepDeployMacro(configuration, currentDomainCreationStep, dc), "Deployment of [" + dc.getName() + "]"));
			}
		}
		
		// Manage the re-deploy commands
		if (currentDomainCreationStep.hasRedeployConfigurations()) {
			for (RedeployConfiguration rc : currentDomainCreationStep.getRedeployConfigurations()) {
				registerCommand(new MacroMacroCommand(new DomainStepRedeployMacro(configuration, currentDomainCreationStep, rc), "Redeployment of [" + rc.getName() + "]"));
			}
		}

		// Manage the un-deploy commands
		if (currentDomainCreationStep.hasUndeployConfigurations()) {
			for (UndeployConfiguration uc : currentDomainCreationStep.getUndeployConfigurations()) {
				registerCommand(new MacroMacroCommand(new DomainStepUndedeployMacro(configuration, currentDomainCreationStep, uc), "Redeployment of [" + uc.getName() + "]"));
			}
		}
		
		if (currentDomainCreationStep.isRestartAfter()) {
			registerCommand(new MacroMacroCommand(new RestartDomainMacro(configuration), "Restart the domain after the creation step."));
		}
	}
}
