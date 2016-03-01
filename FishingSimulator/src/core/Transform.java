package core;

import math.Matrix4f;
import math.Vector3f;

public class Transform {

	private static float zNear;
	private static float zFar;
	private static float width;
	private static float height;
	private static float fov;

	private Vector3f translation;
	private Vector3f rotation;
	private Vector3f scale;

	public Transform() {
		translation = new Vector3f(0, 0, 0);
		rotation = new Vector3f(0, 0, 0);
		scale = new Vector3f(1, 1, 1);
	}

	public Matrix4f getTransformation() {

		Matrix4f translationMatrix = new Matrix4f().InitTranslation(translation.GetX(), translation.GetY(),
				translation.GetZ());
		Matrix4f rotationMatrix = new Matrix4f().InitRotation(rotation.GetY(), rotation.GetY(), rotation.GetZ());
		Matrix4f scaleMatrix = new Matrix4f().InitScale(scale.GetX(), scale.GetY(), scale.GetZ());

		return translationMatrix.Mul(rotationMatrix.Mul(scaleMatrix));
	}

	public Matrix4f getProjectedTransformation() {
		
		Matrix4f transformationMatrix = getTransformation();
		Matrix4f projectionMatrix = new Matrix4f().InitPerspective(fov, width/height, zNear, zFar);
		
		
		
		return projectionMatrix.Mul(transformationMatrix);
	}

	public static void setProjection(float fov, float width, float height, float zNear, float zFar) {
		Transform.fov = fov;
		Transform.width = width;
		Transform.height = height;
		Transform.zNear = zNear;
		Transform.zFar = zFar;
	}

	public Vector3f getTranslation() {
		return translation;
	}

	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}

	public void setTranslation(float x, float y, float z) {
		setTranslation(new Vector3f(x, y, z));
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public void setRotation(float x, float y, float z) {
		setRotation(new Vector3f(x, y, z));
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

	public void setScale(float x, float y, float z) {
		setScale(new Vector3f(x, y, z));
	}

}
