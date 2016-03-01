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
		
		

		while (running) {
			
			if(Window.isCLoseRequested())
				stop();
			
			
			update();
			render();
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
