package render;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

	private int program;

	public Shader() {
		program = glCreateProgram();

		if (program == 0) {
			System.err.println("Shader creation failed: Could not find valid memory location");
			System.exit(1);
		}

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
	
	public void bind(){
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

}
