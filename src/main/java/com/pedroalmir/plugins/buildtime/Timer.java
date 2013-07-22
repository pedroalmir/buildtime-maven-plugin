package com.pedroalmir.plugins.buildtime;

/**
 * @author Pedro Almir
 *
 */
public class Timer {

	/**
	 * Begin time
	 */
	private static long beginTime = System.currentTimeMillis();
	/**
	 * Adjustment factor
	 */
	private static final long ADJUSTMENT_FACTOR = 700l;
	/**
	 * Start timer
	 */
	public static void start() {
		beginTime = System.currentTimeMillis();
	}

	/**
	 * @return elapsed time
	 */
	public static long elapsedTime() {
		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - beginTime;
		return elapsedTime + ADJUSTMENT_FACTOR;
	}

}
