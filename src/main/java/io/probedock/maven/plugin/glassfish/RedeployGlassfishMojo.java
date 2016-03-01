package io.probedock.maven.plugin.glassfish;

import io.probedock.maven.plugin.glassfish.macro.AbstractMacro;
import io.probedock.maven.plugin.glassfish.macro.RedeployMacro;
import io.probedock.maven.plugin.glassfish.model.Configuration;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import io.probedock.maven.plugin.glassfish.model.RedeployConfiguration;

/**
 * Re-deploy an application on a glassfish domain
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
@Mojo(name = "redeploy", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST, requiresProject = true)
public class RedeployGlassfishMojo extends GlassfishMojo {
	@Parameter(required = true)
	private RedeployConfiguration deployConfig;

	@Override
	protected AbstractMacro getMacro() {
		return new RedeployMacro(configuration);
	}

	@Override
	protected Configuration buildConfiguration() {
		return new Configuration(getLog(), glassfish, domain, deployConfig);
	}
}
