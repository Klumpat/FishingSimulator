package render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

	public static void createWindow(int width, int height, String title) {

		Display.setTitle(title);
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

	}

	public static void render() {
		Display.update();
	}

	public static boolean isCloseRequested() {
		return Display.isCloseRequested();
	}

	public static int getWidth() {
		return Display.getWidth();
	}

	public static int getHeight() {
		return Display.getHeight();
	}

	public static String getTitle() {
		return Display.getTitle();
	}

	public static void destroyWindow() {
		Display.destroy();
	}

}
