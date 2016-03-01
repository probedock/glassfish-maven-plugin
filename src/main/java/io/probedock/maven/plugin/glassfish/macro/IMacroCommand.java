package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.command.CommandExecutor;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Define what is a macro command to be run in a macro
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public interface IMacroCommand {
	/**
	 * Execute the macro command
	 * 
	 * @param executor The executor for the commands
	 * @throws MojoExecutionException When macro cannot be executed
	 * @throws MojoFailureException When macro failed to be executed
	 */
	void execute(CommandExecutor executor) throws MojoExecutionException, MojoFailureException;
	
	/**
	 * @return Retrieve a description text for the macro command
	 */
	String getDescriptionText();
}
