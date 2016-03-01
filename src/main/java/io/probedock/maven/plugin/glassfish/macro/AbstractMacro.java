package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.command.CommandExecutor;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import java.util.ArrayList;
import java.util.List;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Base macro to run grouped commands
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public abstract class AbstractMacro {
	/**
	 * The general configuration to use
	 */
	protected Configuration configuration;

	/**
	 * The list of macro commands to run
	 */
	private final List<IMacroCommand> commands = new ArrayList<>();
	
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public AbstractMacro(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Execute the macro
	 * 
	 * @param executor The executor to run the commands of the macro
	 * @throws MojoExecutionException When a command is not executable
	 * @throws MojoFailureException When a command has failed
	 */
	public void execute(CommandExecutor executor) throws MojoExecutionException, MojoFailureException {
		// Run each macro command
		for (IMacroCommand macroCommand : commands) {
			configuration.getLog().info(formatMessage(macroCommand));
			macroCommand.execute(executor);
		}
	}

	/**
	 * Register a macro command to run
	 * 
	 * @param macroCommand The macro command to register
	 */
	protected void registerCommand(IMacroCommand macroCommand) {
		if (macroCommand != null) {
			commands.add(macroCommand);
		}
	}
	
	/**
	 * @return True if the domain is a local domain
	 */
	protected boolean isLocalDomain() {
		return configuration.isLocalDomain();
	}
	
	/**
	 * Build a message from the macro command description
	 * 
	 * @param macroCommand The macro command to get the description
	 * @return The message built
	 */
	protected String buildMessage(IMacroCommand macroCommand) {
		return macroCommand.getDescriptionText();
	}

	/**
	 * Format the macro command description
	 * 
	 * @param macroCommand The macro command to format
	 * @return The message formated
	 */
	private String formatMessage(IMacroCommand macroCommand) {
		return "*****> " + buildMessage(macroCommand) + " <*****";
	}
}
