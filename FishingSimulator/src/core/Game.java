package core;


import math.Vector2f;
import math.Vector3f;
import render.BasicShader;
import render.Camera;
import render.Material;
import render.Mesh;
import render.Shader;
import render.Vertex;
import render.Window;

public class Game {

	private Mesh mesh;
	private Shader shader;
	private Material material;
	private Transform transform;
	private Camera camera;

	public Game() {
		mesh = new Mesh();
		material = new Material(RessourceLoader.loadTexture("test.png"), new Vector3f(0,1,1));
		shader = new BasicShader();
		transform = new Transform();
		camera = new Camera();

		Transform.setProjection(70f,(float) Window.getWidth(), (float)Window.getHeight(), 0.1f, 1000f);
		Transform.setCamera(camera);
		Vertex[] vertices = new Vertex[] { 
				new Vertex(new Vector3f(-1, -1, 0),new Vector2f(0.0f, 0.0f)),
				new Vertex(new Vector3f(0, 1, 0), new Vector2f(0.5f, 0.0f)),
				new Vertex(new Vector3f(1, -1, 0), new Vector2f(1.0f, 0.0f)),
				new Vertex(new Vector3f(0, -1, 1), new Vector2f(0.5f, 1.0f)),
				
		};
		
		int[] indices = new int[]{
				0,1,3,
				3,1,2,
				2,1,0,
				0,2,3,
				
		};


		
		mesh.addVertices(vertices, indices);
	

	}
	
	float temp = 0.0f;
	
	public void update() {
		camera.input();
		temp+=Time.getDelta();
		
		float sin = (float)Math.sin(temp);
		float cos = (float)Math.cos(temp);
		
		transform.setTranslation(0,-0.5f,6);
		transform.setRotation(0, 0, 0);
		//transform.setScale(sin, sin, sin);
		
		
		
	}

	public void render() {
		shader.bind();
		shader.updateUniforms(transform.getTransformation(), transform.getProjectedTransformation(), material);
	
		mesh.draw();
	}

}
