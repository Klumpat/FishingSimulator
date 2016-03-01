package core;

public class Time {

	public static long getTimeNS() {
		return System.nanoTime();
	}

	public static long getTimeMS() {
		return System.currentTimeMillis();
	}

}
