package render;

import org.lwjgl.input.Keyboard;

import core.Time;
import math.Vector3f;

public class Camera {

	public static final Vector3f yAxis = new Vector3f(0, 1, 0);

	private Vector3f position;
	private Vector3f forward;
	private Vector3f up;

	public Camera() {
		this(new Vector3f(0, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, 1, 0));
	}

	public Camera(Vector3f position, Vector3f forward, Vector3f up) {
		this.position = position;
		this.up = up;
		this.forward = forward;

		up.Normalized();
		forward.Normalized();
	}
	
	public void input(){
		
		float movAmt = (float) (Time.getDelta() * 10);
		float rotAmt = (float) (Time.getDelta() * 0.5);
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
			move(getForward(), movAmt);
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
			move(getLeft(), movAmt);
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
			move(getForward(), -movAmt);
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
			move(getRight(), movAmt);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			rotateX(-rotAmt);
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			rotateX(rotAmt);
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			rotateY(-rotAmt);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			rotateY(rotAmt);
		
		
	}

	public void move(Vector3f dir, float amt) {
		position = position.Add(dir.Mul(amt));

	}
	
	public void rotateX(float angle){
		Vector3f hAxis = yAxis.Cross(forward);
		hAxis = hAxis.Normalized();
		
		forward = forward.Rotate(hAxis, angle);
		forward = forward.Normalized();
		
		up = forward.Cross(hAxis);
		up = up.Normalized();
	}
	
	public void rotateY(float angle){
		Vector3f hAxis = yAxis.Cross(forward);
		hAxis = hAxis.Normalized();
		
		forward = forward.Rotate(yAxis, angle);
		forward = forward.Normalized();
		
		up = forward.Cross(hAxis);
		up = up.Normalized();
	}

	public Vector3f getLeft() {
		Vector3f left = forward.Cross(up);
		left = left.Normalized();

		return left;
	}

	public Vector3f getRight() {
		Vector3f right = up.Cross(forward);
		right = right.Normalized();

		return right;
	}

	public Vector3f getForward() {
		return forward;
	}

	public Vector3f getPosition() {
		return position;
	}

	public Vector3f getUp() {
		return up;
	}

	public void setForward(Vector3f forward) {
		this.forward = forward;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public void setUp(Vector3f up) {
		this.up = up;
	}

}
