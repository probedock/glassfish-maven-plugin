package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.ConnectorResource;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;


/**
 * The Connector Resource macro manage the creation of the different connector resource
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 */
public class ConnectorResourceMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 */
	public ConnectorResourceMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);

		// Configure the Conector Resource if there are some
		if (currentDomainCreationStep.hasConnectorResources()) {
			
			for (ConnectorResource connectorResource : currentDomainCreationStep.getConnectorResources()) {
				// Create and register the command
				registerCommand(new MacroCommand(buildCreateConnectorConnectionPoolCommand(configuration, connectorResource), "Create the Connector resource [" + connectorResource.getJndiName()+ "]."));
			}
		}
		
	}
}
