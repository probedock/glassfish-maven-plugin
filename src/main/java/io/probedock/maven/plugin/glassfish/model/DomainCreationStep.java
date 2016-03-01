package io.probedock.maven.plugin.glassfish.model;

import io.probedock.maven.plugin.glassfish.utils.Stringifier;
import java.util.Set;
import org.apache.maven.plugins.annotations.Parameter;

/**
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class DomainCreationStep {
	@Parameter(required = true)
	private String name;
	
	@Parameter(defaultValue = "false")
	private Boolean restartBefore = false;
	
	@Parameter(defaultValue = "false")
	private Boolean restartAfter = false;

	/**
	 * A list of admin object to create
	 */
	@Parameter
	private Set<AdminObject> adminObjects;

	/**
	 * A list of connection factories to create
	 */
	@Parameter
	private Set<ConnectionFactory> connectionFactories;
	
	/**
	 * Define a set of connector connection pool to create
	 */
	@Parameter
	private Set<ConnectorConnectionPool> connectorConnectionPools;

	/**
	 * Define a set of connector resource to create
	 */
	@Parameter
	private Set<ConnectorResource> connectorResources;

	/**
	 * A list of JVM options to create
	 */
	@Parameter
	private Set<String> createJvmOptions;
	
	/**
	 * A list of JVM options to delete
	 */
	@Parameter
	private Set<String> deleteJvmOption;

	/**
	 * A list of JDBC resources to create (resources + pools)
	 */
	@Parameter
	private Set<JdbcResource> jdbcResources;
	
	/**
	 * A list of JMS resources to create (resources + physical destinations)
	 */
	@Parameter
	private Set<JmsResource> jmsResources;

	/**
	 * Additional properties to configure for the domain
	 */
	@Parameter
	private Set<Property> properties;

	/**
	 * A list of Resource Adapter to deploy on the domain
	 */
	@Parameter
	private Set<ResourceAdapter> resourceAdapters;

	/**
	 * Deployments to be done during the domain creation
	 */
	@Parameter
	private Set<DeployConfiguration> deployConfigurations;
	
	/**
	 * Redeplyoments to be done during the domain creation
	 */
	@Parameter 
	private Set<RedeployConfiguration> redeployConfigurations;
	
	/**
	 * Undeployments to be done during the creation
	 */
	@Parameter
	private Set<UndeployConfiguration> undeployConfigurations;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isRestartBefore() {
		return restartBefore;
	}

	public void setRestartBefore(Boolean restartBefore) {
		this.restartBefore = restartBefore;
	}
	
	public Boolean isRestartAfter() {
		return restartAfter;
	}

	public void setRestartAfter(Boolean restartAfter) {
		this.restartAfter = restartAfter;
	}

	public Set<AdminObject> getAdminObjects() {
		return adminObjects;
	}

	public void setAdminObjects(Set<AdminObject> adminObjects) {
		this.adminObjects = adminObjects;
	}

	public Set<ConnectionFactory> getConnectionFactories() {
		return connectionFactories;
	}

	public void setConnectionFactories(Set<ConnectionFactory> connectionFactories) {
		this.connectionFactories = connectionFactories;
	}

	public Set<ConnectorConnectionPool> getConnectorConnectionPools() {
		return connectorConnectionPools;
	}

	public void setConnectorConnectionPools(Set<ConnectorConnectionPool> connectorConnectionPools) {
		this.connectorConnectionPools = connectorConnectionPools;
	}

	public Set<ConnectorResource> getConnectorResources() {
		return connectorResources;
	}

	public void setConnectorResources(Set<ConnectorResource> connectorResources) {
		this.connectorResources = connectorResources;
	}

	public Set<String> getCreateJvmOptions() {
		return createJvmOptions;
	}

	public void setCreateJvmOptions(Set<String> createJvmOptions) {
		this.createJvmOptions = createJvmOptions;
	}

	public Set<String> getDeleteJvmOption() {
		return deleteJvmOption;
	}

	public void setDeleteJvmOption(Set<String> deleteJvmOption) {
		this.deleteJvmOption = deleteJvmOption;
	}

	public Set<JdbcResource> getJdbcResources() {
		return jdbcResources;
	}

	public void setJdbcResources(Set<JdbcResource> jdbcResources) {
		this.jdbcResources = jdbcResources;
	}

	public Set<JmsResource> getJmsResources() {
		return jmsResources;
	}

	public void setJmsResources(Set<JmsResource> jmsResources) {
		this.jmsResources = jmsResources;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public Set<ResourceAdapter> getResourceAdapters() {
		return resourceAdapters;
	}

	public void setResourceAdapters(Set<ResourceAdapter> resourceAdapters) {
		this.resourceAdapters = resourceAdapters;
	}

	public Set<DeployConfiguration> getDeployConfigurations() {
		return deployConfigurations;
	}

	public void setDeployConfigurations(Set<DeployConfiguration> deployConfigurations) {
		this.deployConfigurations = deployConfigurations;
	}

	public Set<RedeployConfiguration> getRedeployConfigurations() {
		return redeployConfigurations;
	}

	public void setRedeployConfigurations(Set<RedeployConfiguration> redeployConfigurations) {
		this.redeployConfigurations = redeployConfigurations;
	}

	public Set<UndeployConfiguration> getUndeployConfigurations() {
		return undeployConfigurations;
	}

	public void setUndeployConfigurations(Set<UndeployConfiguration> undeployConfigurations) {
		this.undeployConfigurations = undeployConfigurations;
	}
	
	public boolean hasConnectorConnectionPools() {
		return connectorConnectionPools != null && !connectorConnectionPools.isEmpty();
	}

	public boolean hasConnectorResources() {
		return connectorResources != null && !connectorResources.isEmpty();
	}	

	public boolean hasResourceAdapters() {
		return resourceAdapters != null && !resourceAdapters.isEmpty();
	}

	public boolean hasAdminObjects() {
		return adminObjects != null && !adminObjects.isEmpty();
	}	

	public boolean hasDeployConfigurations() {
		return deployConfigurations != null && !deployConfigurations.isEmpty();
	}
	
	public boolean hasRedeployConfigurations() {
		return redeployConfigurations != null && !redeployConfigurations.isEmpty();
	}
	
	public boolean hasUndeployConfigurations() {
		return undeployConfigurations != null && !undeployConfigurations.isEmpty();
	}
	
	@Override
	public String toString() {
		return 
			"adminObjects=" + Stringifier.toString(adminObjects) + ", " +
			"createJvmOptions=" + Stringifier.toString(createJvmOptions) + ", " +
			"connectionFactories=" + Stringifier.toString(connectionFactories) + ", " +
			"connectorConnectionPools=" + Stringifier.toString(connectorConnectionPools) + ", " +
			"connectorResources=" + Stringifier.toString(connectorResources) + ", " +
			"deleteJvmOptions=" + Stringifier.toString(deleteJvmOption) + ", " +
			"deployConfigurations=" + Stringifier.toString(deployConfigurations) + ", " +
			"jdbcResources=" + Stringifier.toString(jdbcResources) + ", " +
			"jmsResources" + Stringifier.toString(jmsResources) + ", " + 
			"name=" + name + ", " + 
			"properties=" + Stringifier.toString(properties) + ", " +
			"redeployConfigurations=" + Stringifier.toString(redeployConfigurations) + ", " +
			"resourceAdapaters=" + Stringifier.toString(resourceAdapters) + ", " +
			"restartBefore=" + restartBefore + ", " +
			"restartAfter=" + restartAfter + ", " +
			"undeployConfigurations=" + Stringifier.toString(undeployConfigurations)
		;
	}
}
