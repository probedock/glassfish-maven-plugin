package io.probedock.maven.plugin.glassfish.model;

/**
 * The re-deployment configuration of an application
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class RedeployConfiguration extends AbstractDeployConfiguration {
	public DeployConfiguration getDeployConfiguration() {
		return new DeployConfiguration(this);
	}
}
