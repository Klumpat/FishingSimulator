package core;


import math.Vector3f;
import render.Mesh;
import render.Shader;
import render.Vertex;

public class Game {

	private Mesh mesh;
	private Shader shader;
	private Transform transform;

	public Game() {
		mesh = new Mesh();
		shader = new Shader();
		transform = new Transform();

		Vertex[] data = new Vertex[] { 
				new Vertex(new Vector3f(-1, -1, 0)),
				new Vertex(new Vector3f(0, 1, 0)),
				new Vertex(new Vector3f(1, -1, 0)),
				
		};

		mesh.addVertices(data);

		shader.addVertexShader(RessourceLoader.loadShader("vertex.vs"));
		shader.addFragmentShader(RessourceLoader.loadShader("fragment.vs"));
		shader.compileShader();
		
		shader.addUniform("transform");
	

	}
	
	float temp = 0.0f;
	
	public void update() {
		temp+=Time.getDelta();
		
		float sin = (float)Math.sin(temp);
		float cos = (float)Math.cos(temp);
		
		transform.setTranslation(sin,0,0);
		transform.setRotation(0, 0, sin * 180);
		transform.setScale(sin, sin, sin);
		
		
	}

	public void render() {
		shader.bind();
		shader.setUniform("transform", transform.getTransformation());
		mesh.draw();
	}

}
