package core;

import org.lwjgl.util.vector.Vector3f;

import render.Mesh;
import render.Shader;
import render.Vertex;

public class Game {

	private Mesh mesh;
	private Shader shader;

	public Game() {
		mesh = new Mesh();
		shader = new Shader();

		Vertex[] data = new Vertex[] { 
				new Vertex(new Vector3f(-1, -1, 0)),
				new Vertex(new Vector3f(0, 1, 0)),
				new Vertex(new Vector3f(1, -1, 0)),
				
		};

		mesh.addVertices(data);

		shader.addVertexShader(RessourceLoader.loadShader("vertex.vs"));
		shader.addFragmentShader(RessourceLoader.loadShader("fragment.vs"));
		
		shader.compileShader();
		shader.addUniform("test");
		
		
		

	}
	
	float temp = 0.0f;
	
	public void update() {
		temp+=Time.getDelta();
		
		shader.setUniformf("test", (float)Math.sin(temp));
	}

	public void render() {
		shader.bind();
		mesh.draw();
	}

}
