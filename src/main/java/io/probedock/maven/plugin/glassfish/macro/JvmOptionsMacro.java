package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * The JVM Options macro allows creating and deleting JVM options
 * 
 * @author Laurent Prevost, laurent.prevost@lotaris.com
 */
public class JvmOptionsMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public JvmOptionsMacro(Configuration configuration) {
		super(configuration);

		registerCommand(new MacroCommand(buildDeleteJvmOptionsCommand(configuration), "Remove JVM options."));
		registerCommand(new MacroCommand(buildCreateJvmOptionsCommand(configuration), "Create JVM options."));
	}
}
