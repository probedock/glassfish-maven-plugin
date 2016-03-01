package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;
import io.probedock.maven.plugin.glassfish.model.ResourceAdapter;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.buildCreateAdapterConfigCommand;


/**
 * The Resource Adapter macro manage the creation of the different resource adapters for a domain.
 *  
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class ResourceAdaptersMacro extends AbstractCreationStepMacro {

	public ResourceAdaptersMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);
		
		// Configure the JMS Hosts if there are some
		if (currentDomainCreationStep.hasResourceAdapters()) {
			for (ResourceAdapter resourceAdapter : currentDomainCreationStep.getResourceAdapters()) {
				// Configure if properties are present
				if(resourceAdapter.hasProperties()) {
					registerCommand(new MacroCommand(buildCreateAdapterConfigCommand(configuration, resourceAdapter), "Create configuration for resource adapter [" + resourceAdapter.getName() + "]."));
				}	
			}
		}
	}
}
