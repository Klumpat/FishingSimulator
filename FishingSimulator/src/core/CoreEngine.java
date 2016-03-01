package core;

import render.RenderUtils;
import render.Window;

public class CoreEngine {

	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 5 * 4;
	public static final String TITLE = "FishingSimulator";

	private boolean running;

	private Game game;

	public CoreEngine() {
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		System.out.println("OpenGL Version: "+RenderUtils.getGLVersion());
		RenderUtils.initGL();
		running = false;

		game = new Game();

	}

	public void update() {
		game.update();
	}

	public void render() {
		RenderUtils.clearScreen();
		game.render();
		Window.render();
	}

	public void gameLoop() {

		final double updatesPerSecond = 60.0;
		final double nsPerUpdate = 1.0 / updatesPerSecond;

		int frames = 0;
		int updates = 0;

		long lastTime = Time.getTimeNS();
		long secTimer = Time.getTimeMS();

		double delta = 0.0;

		while (running) {

			if (Window.isCloseRequested())
				stop();

			long currentTime = Time.getTimeNS();
			delta += (currentTime - lastTime) / 1000000000.0;
			lastTime = currentTime;

			while (delta >= nsPerUpdate) {
				Time.setDelta(delta);
				delta -= nsPerUpdate;
				update();
				updates++;

			}

			render();
			frames++;

			if (Time.getTimeMS() - secTimer >= 1000) {
				secTimer += 1000;
				System.out.println("fps: " + frames + " ups: " + updates);
				frames = 0;
				updates = 0;
			}

		}

		cleanUp();

	}

	public void start() {
		if (running)
			return;

		running = true;
		gameLoop();

	}

	public void stop() {
		if (!running)
			return;

		running = false;

	}

	public void cleanUp() {

	}

	public static void main(String[] args) {
		new CoreEngine().start();
	}

}
