package com.pedroalmir.plugins.buildtime;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.execution.RuntimeInformation;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;

import com.google.gson.Gson;

/**
 * Goal that reports the build time
 * 
 * @goal stop
 * @requiresOnline true
 */
public class StopTimer extends AbstractMojo {
	/**
	 * 
	 */
	private static final String DEFAULT_URL = "http://buildtime-maven-plugin.appspot.com/";
	/**
	 * The stops build and reports elapsed time
	 * 
	 * @parameter reportUrl=""
	 */
	private String reportUrl;

	/**
	 * The maven session
	 * @parameter expression="${session}" 
	 */
	private MavenSession session;
	/**
	 * Settings
	 * @parameter expression="${settings}"
	 */
	private Settings settings;
	/** 
	 * @component 
	 * */
	private RuntimeInformation runtime;

	@SuppressWarnings("unchecked")
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
			buildInformation.setMavenVersion(runtime.getApplicationVersion().toString());
			buildInformation.setGoals(session.getGoals());
			
			buildInformation.getGoals().remove("buildtime:start");
			buildInformation.getGoals().remove("buildtime:stop");
			
			getLog().debug("\n\n" + session.getGoals() + "\n\n");
			buildInformation.setProfiles(settings.getActiveProfiles());
			
			/* Date informations */
			buildInformation.setBuildDate(new Date());
			long elapsedTime = Timer.elapsedTime();
			buildInformation.setElapsedTime(elapsedTime);

			getLog().info("##### Stopping timer! Elapsed Time (" + Timer.elapsedTime() + " ms)");
			getLog().debug("##### Sending informations!");

			getLog().info("##### Sending information ! ! !");
			sendInformations(reportUrl, buildInformation);

			getLog().info("##### Stopping plugin ! ! !");
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
	private void sendInformations(String reportUrl, BuildInformation buildInformation) throws ClientProtocolException,
			IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = null;

		if (reportUrl != null && !reportUrl.isEmpty()) {
			postRequest = new HttpPost(reportUrl);
			getLog().debug("####### URL: " + reportUrl);
		} else {
			postRequest = new HttpPost(DEFAULT_URL);
			getLog().debug("####### URL: " + DEFAULT_URL);
		}

		getLog().debug("####### JSON: \n\n" + new Gson().toJson(buildInformation) + "\n\n");

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("buildInformation", new Gson().toJson(buildInformation)));
		postRequest.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = httpClient.execute(postRequest);
		getLog().debug("####### Status Code: " + response.getStatusLine().getStatusCode());

	}

}
