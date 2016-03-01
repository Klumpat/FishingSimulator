package core;


import render.Mesh;
import render.Shader;
import render.Window;

public class Game {

	private Mesh mesh;
	private Shader shader;
	private Transform transform;

	public Game() {
		mesh = RessourceLoader.loadMesh("box.obj");
		shader = new Shader();
		transform = new Transform();
		Transform.setProjection(70f,(float) Window.getWidth(), (float)Window.getHeight(), 0.1f, 1000f);

//		Vertex[] vertices = new Vertex[] { 
//				new Vertex(new Vector3f(-1, -1, 0)),
//				new Vertex(new Vector3f(0, 1, 0)),
//				new Vertex(new Vector3f(1, -1, 0)),
//				new Vertex(new Vector3f(0, -1, 1)),
//				
//		};
//		
//		int[] indices = new int[]{
//				0,1,3,
//				3,1,2,
//				2,1,0,
//				0,2,3,
//				
//		};


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
		
		transform.setTranslation(sin,-0.5f,6);
		transform.setRotation(sin * 10, 0, 0);
		//transform.setScale(sin, sin, sin);
		
		
		
	}

	public void render() {
		shader.bind();
		shader.setUniform("transform", transform.getProjectedTransformation());
		mesh.draw();
	}

}
