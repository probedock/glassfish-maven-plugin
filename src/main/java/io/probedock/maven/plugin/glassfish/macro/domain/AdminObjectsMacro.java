package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.AbstractMacro;
import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.AdminObject;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;


/**
 * The Admin Object macro manage the creation of the different admin object
 * 
 * @author Valentin Delaye valentin.delaye@novaccess.ch
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class AdminObjectsMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 */
	public AdminObjectsMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);

		// Configure the Admin Objects if there are some
		if (currentDomainCreationStep.hasAdminObjects()) {
			
			for (AdminObject adminobject : currentDomainCreationStep.getAdminObjects()) {
				// Create and register the command
				registerCommand(new MacroCommand(buildCreateAdminObjectCommand(configuration, adminobject), "Create the Admin Object [" + adminobject.getJndiName()+ "]."));
			}
		}
		
	}
}
