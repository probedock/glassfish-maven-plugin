package io.probedock.maven.plugin.glassfish;

import io.probedock.maven.plugin.glassfish.macro.AbstractMacro;
import io.probedock.maven.plugin.glassfish.macro.SingleCommandMacro;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import static io.probedock.maven.plugin.glassfish.command.CommandFactory.*;

/**
 * Maven goal to stop a Glassfish domain
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
@Mojo(name = "stop-domain", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST, requiresProject = true)
public class StopDomainGlassfishMojo extends GlassfishMojo {
	@Override
	protected AbstractMacro getMacro() {
		if (configuration.getDomain().exists()) {
			return new SingleCommandMacro(configuration, buildStopDomainCommand(configuration), "Stopping domain.");
		}
		else {
			throw new IllegalStateException("Domain does not exist.");
		}
	}
}
