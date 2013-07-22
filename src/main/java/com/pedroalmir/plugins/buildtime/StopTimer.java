package com.pedroalmir.plugins.buildtime;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import com.google.gson.Gson;

/**
 * Goal that reports the build time
 * 
 * @goal stop
 * @phase package
 * @requiresOnline true
 */
public class StopTimer extends AbstractMojo {
	/**
	 * 
	 */
	private static final String DEFAULT_URL = "http://buildtime-maven-plugin.appspot.com/buildTime";
	/**
	 * The stops build and reports elapsed time
	 * 
	 * @parameter reportUrl=""
	 */
	private String reportUrl;

	public void execute() throws MojoExecutionException {
		try {
			BuildInformation buildInformation = new BuildInformation();
			
			MavenProject project = (MavenProject) getPluginContext().get("project");
			/* Project informations */
			buildInformation.setProjectName(project.getName());
			buildInformation.setGroupID(project.getGroupId());
			buildInformation.setArtifactID(project.getArtifactId());
			buildInformation.setVersion(project.getVersion());
			
			/* OS informations */
			buildInformation.setBuildServer(InetAddress.getLocalHost().getHostName());
			buildInformation.setOperatingSystem(System.getProperty("os.name"));
			buildInformation.setOsArchitecture(System.getProperty("os.arch"));
			buildInformation.setOsVersion(System.getProperty("os.version"));
			buildInformation.setBuildUser(System.getProperty("user.name"));
			
			/* Maven Informations: How get this informations ? ? ? */
			buildInformation.setMavenVersion(null);
			buildInformation.setGoals(null);
			buildInformation.setProfiles(null);
			
			/* Date informations */
			buildInformation.setBuildDate(new Date());
			long elapsedTime = Timer.elapsedTime();
			buildInformation.setElapsedTime(new Date(elapsedTime));
			
			getLog().debug("##### Stopping timer! Elapsed Time (" + Timer.elapsedTime() + " ms)");
			getLog().debug("##### Sending informations!");
			sendInformations(reportUrl, buildInformation);

		} catch (Exception e) {
			getLog().error("Exception caught =" + e.getMessage());
		}
	}

	/**
	 * @param reportUrl
	 * @param buildInformation
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	private void sendInformations(String reportUrl, BuildInformation buildInformation) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = null;
		
		if(reportUrl != null && !reportUrl.isEmpty()){
			postRequest = new HttpPost(reportUrl);
		}else{
			postRequest = new HttpPost(DEFAULT_URL);
		}
		
		postRequest.setHeader("Content-Type", "application/json");
		postRequest.setEntity(new StringEntity(new Gson().toJson(buildInformation), "UTF-8"));
		httpClient.execute(postRequest);
		httpClient.getConnectionManager().shutdown();
	}
}