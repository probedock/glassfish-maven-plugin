package io.probedock.maven.plugin.glassfish;

import io.probedock.maven.plugin.glassfish.macro.AbstractMacro;
import io.probedock.maven.plugin.glassfish.macro.UndedeployMacro;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import io.probedock.maven.plugin.glassfish.model.UndeployConfiguration;

/**
 * Un-deploy an application on a glassfish domain
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
@Mojo(name = "undeploy", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST, requiresProject = true)
public class UndeployGlassfishMojo extends GlassfishMojo {
	@Parameter(required = true)
	private UndeployConfiguration deployConfig;

	@Override
	protected AbstractMacro getMacro() {
		return new UndedeployMacro(configuration);
	}

	@Override
	protected Configuration buildConfiguration() {
		return new Configuration(getLog(), glassfish, domain, deployConfig);
	}
}
