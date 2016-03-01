package core;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import math.Matrix4f;
import render.Vertex;

public class Utils {

	public static FloatBuffer createFloatBuffer(int size) {
		return BufferUtils.createFloatBuffer(size);
	}

	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {

		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);

		for (int i = 0; i < vertices.length; i++) {
			buffer.put(vertices[i].getPosition().GetX());
			buffer.put(vertices[i].getPosition().GetY());
			buffer.put(vertices[i].getPosition().GetZ());
		}

		buffer.flip();

		return buffer;

	}

	public static FloatBuffer createFlippedBuffer(Matrix4f value) {
		FloatBuffer buffer = createFloatBuffer(4 * 4);
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				buffer.put(value.Get(i, j));
		
		buffer.flip();
		
		return buffer;
	}

}
