package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.ResourceAdapter;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Deploy resource adapter macro
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 */
public class DeployResourceAdapterMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param resourceAdapter The resource adapter to deploy
	 */
	public DeployResourceAdapterMacro(Configuration configuration, ResourceAdapter resourceAdapter) {
		super(configuration);
		registerCommand(new MacroCommand(buildDeployCommand(configuration, resourceAdapter.getDeployConfig()), "Deploying resource adapter [" + resourceAdapter.getDeployConfig().getName() + "]."));
		
		// Configure if properties are set
		if(resourceAdapter.hasProperties()) {
			registerCommand(new MacroCommand(buildCreateAdapterConfigCommand(configuration, resourceAdapter), "Create configuration for resource adapter [" + resourceAdapter.getDeployConfig().getName() + "]."));
		}	
	}
}
