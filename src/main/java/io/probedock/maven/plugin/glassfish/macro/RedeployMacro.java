package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Redeploy application macro take care of the requirements (like domain created and started)
 * 
 * @author Laurent Prevost, laurent.prevost@lotaris.com
 */
public class RedeployMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public RedeployMacro(Configuration configuration) {
		super(configuration);

		// Check if the domain does not exist
		if (!configuration.getDomain().exists()) {
			if (isLocalDomain()) {
				registerCommand(new MacroMacroCommand(new CreateDomainMacro(configuration), "Creating domain."));
			}
			
			configuration.setDeployConfiguration(configuration.getRedeployConfiguration().getDeployConfiguration());
			registerCommand(new MacroCommand(buildDeployCommand(configuration), "Deploy application [" + configuration.getRedeployConfiguration().getName() + "]."));
		}
		
		else {
			// Check if the domain is not started
			if (isLocalDomain() && !configuration.getDomain().isStarted()) {
				registerCommand(new MacroMacroCommand(new StartDomainMacro(configuration), "Starting domain."));
			}

			registerCommand(new MacroCommand(buildRedeployCommand(configuration), "Redeploying application [" + configuration.getRedeployConfiguration().getName() + "]."));
		}
	}
}
