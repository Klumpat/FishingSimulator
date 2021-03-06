package render;

import math.Vector2f;
import math.Vector3f;

public class Vertex {

	public static final int SIZE = 5;

	private Vector3f position;
	private Vector2f texCoord;

	public Vertex(Vector3f position) {
		this(position, new Vector2f(0,0));
	}
	
	public Vertex(Vector3f position, Vector2f texCoord) {
		this.position = position;
		this.texCoord = texCoord;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public Vector2f getTexCoord() {
		return texCoord;
	}
	public void setTexCoord(Vector2f texCoord) {
		this.texCoord = texCoord;
	}

}
