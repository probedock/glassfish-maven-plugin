package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.AbstractMacro;
import io.probedock.maven.plugin.glassfish.macro.IMacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;

/**
 * Abstract creation step macro for a domain
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class AbstractCreationStepMacro extends AbstractMacro {
	/**
	 * Current domain creation step
	 */
	protected DomainCreationStep currentDomainCreationStep;
	
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCrationStep The current step to create the domain
	 */
	public AbstractCreationStepMacro(Configuration configuration, DomainCreationStep domainCrationStep) {
		super(configuration);
		
		currentDomainCreationStep = domainCrationStep;
	}

	@Override
	protected String buildMessage(IMacroCommand macroCommand) {
		return "[Step: " + currentDomainCreationStep.getName() + "] " + super.buildMessage(macroCommand);
	}
}
