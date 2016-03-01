package core;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import render.Vertex;

public class Utils {

	public static FloatBuffer createFloatBuffer(int size) {
		return BufferUtils.createFloatBuffer(size);
	}

	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {

		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);

		for (int i = 0; i < vertices.length; i++) {
			buffer.put(vertices[i].getPosition().x);
			buffer.put(vertices[i].getPosition().y);
			buffer.put(vertices[i].getPosition().z);
		}

		buffer.flip();

		return buffer;

	}

}
