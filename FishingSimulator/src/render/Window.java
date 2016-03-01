package render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

	private static boolean vsynced = false;

	public static void createWindow(int width, int height, boolean vsynced) {
		Window.vsynced = vsynced;
		DisplayMode dm = new DisplayMode(width, height);
		try {
			Display.create();
			Display.setDisplayMode(dm);

			if (vsynced)
				Display.setVSyncEnabled(vsynced);

		} catch (LWJGLException e) {
			e.printStackTrace();
		}

	}

	public static void update() {
		Display.update();
	}

	public static void destroy() {
		Display.destroy();
	}

	public static int getWidth() {
		return Display.getWidth();
	}

	public static int getHeight() {
		return Display.getHeight();
	}

	public static boolean isCLoseRequested() {
		return Display.isCloseRequested();
	}

}
