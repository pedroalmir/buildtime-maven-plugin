/**
 * 
 */
package com.pedroalmir.plugins.buildtime;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Model class which will store the task items
 * 
 * @author Pedro Almir
 * 
 */
public class BuildInformation {
	
	private Long id;

	private String projectName;
	private String groupID;
	private String artifactID;
	private String version;
	
	private String buildServer;
	private String operatingSystem;
	private String osArchitecture;
	private String osVersion;
	private String buildUser;
	
	private String mavenVersion;
	private List<String> goals;
	private List<String> profiles;
	
	private Date buildDate;
	private Date elapsedTime;
	
	/**
	 * Default constructor
	 */
	public BuildInformation() {
		this.goals = new LinkedList<String>();
		this.profiles = new LinkedList<String>();
	}
	
	/**
	 * @param id
	 * @param projectName
	 * @param groupID
	 * @param artifactID
	 * @param version
	 * @param buildServer
	 * @param operatingSystem
	 * @param osArchitecture
	 * @param osVersion
	 * @param buildUser
	 * @param mavenVersion
	 * @param goals
	 * @param profiles
	 * @param buildDate
	 * @param elapsedTime
	 */
	public BuildInformation(String projectName, String groupID, String artifactID, String version, String buildServer,
			String operatingSystem, String osArchitecture, String osVersion, String buildUser, String mavenVersion,
			List<String> goals, List<String> profiles, Date buildDate, Date elapsedTime) {
		super();
		this.projectName = projectName;
		this.groupID = groupID;
		this.artifactID = artifactID;
		this.version = version;
		this.buildServer = buildServer;
		this.operatingSystem = operatingSystem;
		this.osArchitecture = osArchitecture;
		this.osVersion = osVersion;
		this.buildUser = buildUser;
		this.mavenVersion = mavenVersion;
		this.goals = goals;
		this.profiles = profiles;
		this.buildDate = buildDate;
		this.elapsedTime = elapsedTime;
	}


	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the groupID
	 */
	public String getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	/**
	 * @return the artifactID
	 */
	public String getArtifactID() {
		return artifactID;
	}

	/**
	 * @param artifactID the artifactID to set
	 */
	public void setArtifactID(String artifactID) {
		this.artifactID = artifactID;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the buildServer
	 */
	public String getBuildServer() {
		return buildServer;
	}

	/**
	 * @param buildServer the buildServer to set
	 */
	public void setBuildServer(String buildServer) {
		this.buildServer = buildServer;
	}

	/**
	 * @return the operatingSystem
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @return the osArchitecture
	 */
	public String getOsArchitecture() {
		return osArchitecture;
	}

	/**
	 * @param osArchitecture the osArchitecture to set
	 */
	public void setOsArchitecture(String osArchitecture) {
		this.osArchitecture = osArchitecture;
	}

	/**
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * @param osVersion the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/**
	 * @return the buildUser
	 */
	public String getBuildUser() {
		return buildUser;
	}

	/**
	 * @param buildUser the buildUser to set
	 */
	public void setBuildUser(String buildUser) {
		this.buildUser = buildUser;
	}

	/**
	 * @return the mavenVersion
	 */
	public String getMavenVersion() {
		return mavenVersion;
	}

	/**
	 * @param mavenVersion the mavenVersion to set
	 */
	public void setMavenVersion(String mavenVersion) {
		this.mavenVersion = mavenVersion;
	}

	/**
	 * @return the goals
	 */
	public List<String> getGoals() {
		return goals;
	}

	/**
	 * @param goals the goals to set
	 */
	public void setGoals(List<String> goals) {
		this.goals = goals;
	}

	/**
	 * @return the profiles
	 */
	public List<String> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles the profiles to set
	 */
	public void setProfiles(List<String> profiles) {
		this.profiles = profiles;
	}

	/**
	 * @return the buildDate
	 */
	public Date getBuildDate() {
		return buildDate;
	}

	/**
	 * @param buildDate the buildDate to set
	 */
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	/**
	 * @return the elapsedTime
	 */
	public Date getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(Date elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuildInformation [projectName=" + projectName + ", groupID=" + groupID + ", artifactID="
				+ artifactID + ", version=" + version + ", buildServer=" + buildServer + ", operatingSystem=" + operatingSystem
				+ ", osArchitecture=" + osArchitecture + ", osVersion=" + osVersion + ", buildUser=" + buildUser
				+ ", mavenVersion=" + mavenVersion + ", goals=" + goals + ", profiles=" + profiles + ", buildDate=" + buildDate
				+ ", elapsedTime=" + elapsedTime + "]";
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	

}