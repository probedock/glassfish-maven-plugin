package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

import io.probedock.maven.plugin.glassfish.model.Property;

/**
 * This macro take care of creating set configuration for a domain
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class SetCommandMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCrationStep The current domain creation step
	 */
	public SetCommandMacro(Configuration configuration, DomainCreationStep domainCrationStep) {
		super(configuration, domainCrationStep);

		if (currentDomainCreationStep.getProperties() != null) {
			for (Property property : currentDomainCreationStep.getProperties()) {
				registerCommand(new MacroCommand(buildSetCommand(configuration, property), "Setting domain property: " + property.getName()));
			}
		}
  }
}
