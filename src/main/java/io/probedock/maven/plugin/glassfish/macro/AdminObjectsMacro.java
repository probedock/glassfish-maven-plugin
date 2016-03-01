package io.probedock.maven.plugin.glassfish.macro;

import io.probedock.maven.plugin.glassfish.model.AdminObject;
import io.probedock.maven.plugin.glassfish.model.Configuration;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;


/**
 * The Admin Object macro manage the creation of the different admin object
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 */
public class AdminObjectsMacro extends AbstractMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public AdminObjectsMacro(Configuration configuration) {
		super(configuration);

		// Configure the Admin Objects if there are some
		if (configuration.getDomain().hasAdminObjects()) {
			
			for (AdminObject adminobject : configuration.getDomain().getAdminObjects()) {
				// Create and register the command
				registerCommand(new MacroCommand(buildCreateAdminObjectCommand(configuration, adminobject), "Create the Admin Object [" + adminobject.getJndiName()+ "]."));
			}
		}
		
	}
}
