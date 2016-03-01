package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.command.CommandBuilder;
import io.probedock.maven.plugin.glassfish.model.Configuration;

/**
 * The single command macro can be used to just run one command in the macro mecanism that is
 * used everywhere to run the commands.
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class SingleCommandMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param command The command to run
	 * @param descriptionText The descriptive text of the command
	 */
	public SingleCommandMacro(Configuration configuration, CommandBuilder command, String descriptionText) {
		super(configuration);
		registerCommand(new MacroCommand(command, descriptionText));
	}
}
