package core;

import render.Window;

public class CoreEngine {

	private boolean running;

	public CoreEngine() {
		running = false;
		Window.createWindow(800, 600, false);

	}

	public void update() {

	}

	public void render() {
		Window.update();
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

			if (Window.isCLoseRequested())
				stop();

			long currentTime = Time.getTimeNS();
			delta += (currentTime - lastTime) / 1000000000.0;
			lastTime = currentTime;

			while (delta >= nsPerUpdate) {
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
		Window.destroy();

	}

	public static void main(String[] args) {
		new CoreEngine().start();
	}

}
