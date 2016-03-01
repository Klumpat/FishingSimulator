package render;

import static org.lwjgl.opengl.GL20.*;

import java.util.HashMap;

import core.Utils;
import math.Matrix4f;
import math.Vector3f;

public class Shader {

	private int program;
	private HashMap<String, Integer> uniforms;

	public Shader() {
		program = glCreateProgram();
		uniforms = new HashMap<String, Integer>();

		if (program == 0) {
			System.err.println("Shader creation failed: Could not find valid memory location");
			System.exit(1);
		}

	}

	public void addUniform(String uniform) {
		int uniformLocation = glGetUniformLocation(program, uniform);
		
		System.out.println(uniformLocation);

		if (uniformLocation == 0xffffffff) {
			System.err.println("Error: could not find uniform: " + uniform);
			System.exit(1);
		}

		uniforms.put(uniform, uniformLocation);

	}

	public void addVertexShader(String text) {
		addProgram(text, GL_VERTEX_SHADER);
	}

	public void addFragmentShader(String text) {
		addProgram(text, GL_FRAGMENT_SHADER);
	}

	public void compileShader() {
		glLinkProgram(program);

		if (glGetShaderi(program, GL_LINK_STATUS) == 0) {
			System.err.println(glGetShaderInfoLog(program, 1024));
			System.exit(1);
		}

		glValidateProgram(program);

		if (glGetShaderi(program, GL_VALIDATE_STATUS) == 0) {
			System.err.println(glGetShaderInfoLog(program, 1024));
			System.exit(1);
		}

	}

	public void bind() {
		glUseProgram(program);
	}

	private void addProgram(String text, int type) {

		int shader = glCreateShader(type);

		if (shader == 0) {
			System.err.println("Shader creation failed: Could not find valid memory location");
			System.exit(1);
		}

		glShaderSource(shader, text);
		glCompileShader(shader);

		if (glGetShaderi(shader, GL_COMPILE_STATUS) == 0) {
			System.err.println(glGetShaderInfoLog(shader, 1024));
			System.exit(1);
		}

		glAttachShader(program, shader);

	}
	
	public void setUniformi(String uniformName, int value){
		glUniform1i(uniforms.get(uniformName), value);
	}
	
	public void setUniformf(String uniformName, float value){
		glUniform1f(uniforms.get(uniformName), value);
	}
	
	public void setUniform(String uniformName, Vector3f value){
		glUniform3f(uniforms.get(uniformName), value.GetX(),value.GetY(),value.GetZ());
	}
	
	public void setUniform(String uniformName, Matrix4f value){
		glUniformMatrix4(uniforms.get(uniformName),true, Utils.createFlippedBuffer(value));
	}

}
