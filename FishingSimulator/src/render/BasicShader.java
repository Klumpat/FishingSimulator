package render;

import core.RessourceLoader;
import math.Matrix4f;

public class BasicShader extends Shader {

	public BasicShader() {
		super();
		addVertexShader(RessourceLoader.loadShader("vertex.vs"));
		addFragmentShader(RessourceLoader.loadShader("fragment.vs"));
		compileShader();

		addUniform("transform");
		addUniform("color");
	}

	public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material) {
		
		if(material.getTexture() !=null ){
			material.getTexture().bind();
		} else {
			RenderUtils.unbindTextures();
		}
		setUniform("transform", projectedMatrix);
		setUniform("color", material.getColor());
	}

}
