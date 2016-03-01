package io.probedock.maven.plugin.glassfish.macro.domain;

import io.probedock.maven.plugin.glassfish.macro.MacroCommand;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import io.probedock.maven.plugin.glassfish.model.DomainCreationStep;
import io.probedock.maven.plugin.glassfish.model.JdbcResource;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * The JDBC Resource macro manage the creation of the different JDBC resources (connection pools, resources, ...)
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class JdbcResourcesMacro extends AbstractCreationStepMacro {
	/**
	 * Constructor
	 * 
	 * @param configuration The configuration
	 * @param domainCreationStep The current domain creation step
	 */
	public JdbcResourcesMacro(Configuration configuration, DomainCreationStep domainCreationStep) {
		super(configuration, domainCreationStep);

		if (currentDomainCreationStep != null && currentDomainCreationStep.getJdbcResources() != null) {
			for (JdbcResource resource : currentDomainCreationStep.getJdbcResources()) {
				registerCommand(new MacroCommand(buildCreatJdbcConnectionPool(configuration, resource), "Create JDBC connection pool [" + resource.getJndiName() + "]."));
				if(resource.getTimerPool() != null && resource.getTimerPool()) {
					registerCommand(new MacroCommand(buildSetTimerResourceConnectionPool(configuration, resource), "Update jdbc/__TimerPool resource with connection pool [" + resource.getJndiName() + "]."));
				}
				else {
					registerCommand(new MacroCommand(buildCreateJdbcResource(configuration, resource), "Create JDBC resource [" + resource.getJndiName() + "]."));
				}
			}
		}
	}
}
