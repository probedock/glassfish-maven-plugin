package io.probedock.maven.plugin.glassfish.model;

/**
 * The deployment configuration of an application
 * 
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DeployConfiguration extends AbstractDeployConfiguration {
	public DeployConfiguration() {}

	/**
	 * Constructor to copy redeploy configuration into a deploy configuration
	 * 
	 * @param rc Redeploy configuration to copy
	 */
	public DeployConfiguration(RedeployConfiguration rc) {
		super(rc.getName(), rc.getFile(), rc.getForce(), rc.getUpload(), rc.getRetrieve(), rc.getDbVendorName(), rc.getCreateTables(), rc.getDropAndCreateTables(), rc.getUniqueTableNames(), 
			rc.getDeploymentPlan(), rc.getAltdd(), rc.getRuntimeAltdd(), rc.getDeploymentOrder(), rc.getEnabled(), rc.getGenerateRmiStubs(), rc.getContextRoot(), rc.getPreCompileJsp(), 
			rc.getVerify(), rc.getVirtualServers(), rc.getAvailabilityEnabled(), rc.getAsynReplication(), rc.getEnabled(), rc.getKeepState(), rc.getLibraries(), rc.getType(), 
			rc.getProperties());
	}
}
