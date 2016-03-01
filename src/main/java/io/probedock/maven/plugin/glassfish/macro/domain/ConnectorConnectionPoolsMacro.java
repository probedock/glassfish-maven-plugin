package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.ConnectorConnectionPool;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;


/**
 * The Connector Connection Pool macro manage the creation of the different connector connection pool
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class ConnectorConnectionPoolsMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 */
	public ConnectorConnectionPoolsMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);

		// Configure the Conector Connection pool if there are some
		if (currentDomainCreationStep.hasConnectorConnectionPools()) {
			
			for (ConnectorConnectionPool connectionPool : currentDomainCreationStep.getConnectorConnectionPools()) {
				// Create and register the command
				registerCommand(new MacroCommand(buildCreateConnectorConnectionPoolCommand(configuration, connectionPool), "Create the Connector connection pool [" + connectionPool.getJndiName()+ "]."));
			}
		}
		
	}
}
