package com.pedroalmir.plugins.buildtime;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal that starts the stop watch
 * 
 * @goal start
 * @phase validate
 * @requiresOnline true
 */
public class StartTimer extends AbstractMojo {

	public void execute() throws MojoExecutionException {
		getLog().info("##### Starting plugin ! ! !");
		Timer.start();
	}

}
