package core;

public class Time {

	private static double delta = 0.0;

	public static long getTimeNS() {
		return System.nanoTime();
	}

	public static long getTimeMS() {
		return System.currentTimeMillis();
	}

	public static double getDelta() {
		return delta;
	}
	
	public static void setDelta(double delta) {
		Time.delta = delta;
	}
}
