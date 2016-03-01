package core;

import render.Loader;
import render.Mesh;
import render.Renderer;
import render.Window;

public class CoreEngine {

	private boolean running;
	
	Renderer renderer;

	public CoreEngine() {
		running = false;
		Window.createWindow(800, 600, false);
		
		renderer = new Renderer();

	}

	public void update() {

	}

	public void render() {
		
		renderer.prepare();
		
		float[] vertices = {
				-0.5f, 0.5f, 0.0f,
				-0.5f, -0.5f, 0.0f,
				0.5f, -0.5f, 0.0f,
				
				0.5f, -0.5f, 0.0f,
				0.5f, 0.5f, 0.0f,
				-0.5f, 0.5f, 0.0f,
		};
		
		Mesh mesh = Loader.loadToVAO(vertices);
		
		renderer.render(mesh);
		
		
		
		
		
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
		Loader.cleanUp();

	}

	public static void main(String[] args) {
		new CoreEngine().start();
	}

}
