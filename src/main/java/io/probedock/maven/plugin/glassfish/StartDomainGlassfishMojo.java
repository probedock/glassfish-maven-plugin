package io.probedock.maven.plugin.glassfish;

import io.probedock.maven.plugin.glassfish.macro.AbstractMacro;
import io.probedock.maven.plugin.glassfish.macro.StartDomainMacro;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Maven goal to start a glassfish domain
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
@Mojo(name = "start-domain", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST, requiresProject = true)
public class StartDomainGlassfishMojo extends GlassfishMojo {
	@Override
	public AbstractMacro getMacro() {
		return new StartDomainMacro(configuration);
	}
}
