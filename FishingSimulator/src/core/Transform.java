package core;

import math.Matrix4f;
import math.Vector3f;

public class Transform {

	private Vector3f translation;

	public Transform() {
		translation = new Vector3f(0, 0, 0);
	}

	public Matrix4f getTransformation() {

		Matrix4f translationMatrix = new Matrix4f().InitTranslation(translation.GetX(), translation.GetY(),
				translation.GetZ());

		return translationMatrix;
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

}
