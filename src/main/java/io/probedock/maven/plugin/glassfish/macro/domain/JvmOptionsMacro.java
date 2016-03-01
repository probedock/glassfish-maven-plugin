package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * The JVM Options macro allows creating and deleting JVM options
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JvmOptionsMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 */
	public JvmOptionsMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);

		registerCommand(new MacroCommand(buildDeleteJvmOptionsCommand(configuration, currentDomainCreationStep.getDeleteJvmOption()), "Remove JVM options."));
		registerCommand(new MacroCommand(buildCreateJvmOptionsCommand(configuration, currentDomainCreationStep.getCreateJvmOptions()), "Create JVM options."));
	}
}
