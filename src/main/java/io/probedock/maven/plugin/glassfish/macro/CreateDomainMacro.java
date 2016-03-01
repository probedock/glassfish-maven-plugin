package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.macro.domain.AdminObjectsMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.ConnectorResourceMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.ConnectorConnectionPoolsMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.DomainCreationStepMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.ResourceAdaptersMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.JdbcResourcesMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.JmsResourcesMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.SetCommandMacro;
import io.probedock.maven.plugin.glassfish.macro.domain.JvmOptionsMacro;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Create domain macro is used to create a domain. Ensure that the prerequisites conditions are
 * matched to create a new domain (is a domain already exists, started, ...).
 * 
 * Once the domain is created, the different resources (jdbc, jms...) are created.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class CreateDomainMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public CreateDomainMacro(Configuration configuration) {
		super(configuration);

		if (isLocalDomain()) {
			throw new UnsupportedOperationException("The creation of a domain on a remote host is not supported at the moment.");
		}
		
		// Check if the domain exists
		if (configuration.getDomain().exists()) {
			// Check if we can reuse it
			if (configuration.getDomain().isReuse()) {
				registerCommand(new MacroCommand("Domain exists. Reusing it."));
			}
			else {
				// Check if the domain is started
				if (configuration.getDomain().isStarted()) {
					registerCommand(new MacroCommand(buildStopDomainCommand(configuration), "Domain is started. Stopping it."));
				}
				registerCommand(new MacroCommand(buildDeleteDomainCommand(configuration), "Domain exists. Deleting it."));
			}
		}
		
		// Create and start the domain
		registerCommand(new MacroCommand(buildCreateDomainCommand(configuration), "Creating domain."));
		registerCommand(new MacroCommand(buildStartDomainCommand(configuration), "Starting domain."));
		
		// Do the global configuration of JMS on glassfish
		registerCommand(new MacroMacroCommand(new JmsHostsMacro(configuration), "Configure the JMS Hosts."));
		registerCommand(new MacroMacroCommand(new JmsServiceMacro(configuration), "Configure the JMS Service."));
		
		// Configure the logging
		registerCommand(new MacroCommand(buildSetLoggingAttributesCommand(configuration), "Setting the logging attributes."));

		// Do the multi-steps configuration
		for (DomainCreationStep dcs : configuration.getDomain().getCreationSteps()) {
			registerCommand(new MacroMacroCommand(new DomainCreationStepMacro(configuration, dcs), "Process the creation step: [" + dcs.getName() + "]."));
		}

		// Stop the domain
		registerCommand(new MacroCommand(buildStopDomainCommand(configuration), "Stopping domain."));
	}
}
