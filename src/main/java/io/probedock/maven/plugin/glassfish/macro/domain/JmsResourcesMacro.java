package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.ConnectionFactory;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

import io.probedock.maven.plugin.glassfish.model.JmsResource;

/**
 * The JMS Resource macro manage the creation of the different JMS resources (connection factories, resources, ...)
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JmsResourcesMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 */
	public JmsResourcesMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);

		if (configuration.getDomain() != null) {
			// Create every connection factory
			if (currentDomainCreationStep.getConnectionFactories() != null) {
				for (ConnectionFactory connectionFactory : currentDomainCreationStep.getConnectionFactories()) {
					registerCommand(new MacroCommand(buildCreateJmsResourceCommand(configuration, connectionFactory), "Creation of the connection factory [" + connectionFactory.getJndiName() + "]."));
				}
			}
		
			// Create every JMS resource with its physical destination
			if (currentDomainCreationStep.getJmsResources() != null) {
				for (JmsResource resource : currentDomainCreationStep.getJmsResources()) {
					if (resource.isCreatePhysicalDestination()) {
						registerCommand(new MacroCommand(buildCreateJmsDestination(configuration, resource), "Creation of the JMS physical destination [" + resource .getJndiName() + "]."));
					}
					registerCommand(new MacroCommand(buildCreateJmsResourceCommand(configuration, resource), "Creation of the JMS resource [" + resource.getJndiName() + "]."));
				}
			}
		}
	}
}
