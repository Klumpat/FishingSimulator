package core;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;

import math.Matrix4f;
import render.Vertex;

public class Utils {

	public static FloatBuffer createFloatBuffer(int size) {
		return BufferUtils.createFloatBuffer(size);
	}

	public static IntBuffer createIntBuffer(int size) {
		return BufferUtils.createIntBuffer(size);
	}

	public static IntBuffer createFlippedBuffer(int[] values) {
		IntBuffer buffer = createIntBuffer(values.length);

		buffer.put(values);
		buffer.flip();

		return buffer;

	}

	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {

		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);

		for (int i = 0; i < vertices.length; i++) {
			buffer.put(vertices[i].getPosition().GetX());
			buffer.put(vertices[i].getPosition().GetY());
			buffer.put(vertices[i].getPosition().GetZ());
			buffer.put(vertices[i].getTexCoord().GetX());
			buffer.put(vertices[i].getTexCoord().GetY());
		}

		buffer.flip();

		return buffer;

	}

	public static FloatBuffer createFlippedBuffer(Matrix4f value) {
		FloatBuffer buffer = createFloatBuffer(4 * 4);

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				buffer.put(value.Get(i, j));

		buffer.flip();

		return buffer;
	}

	public static String[] removeEmptyStrings(String[] tokens) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < tokens.length; i++) {
			if (!tokens[i].equals("")) {
				result.add(tokens[i]);
			}
		}

		String[] res = new String[result.size()];
		result.toArray(res);

		return res;
	}

	public static int[] toIntArray(Integer[] indices) {

		int[] result = new int[indices.length];

		for (int i = 0; i < indices.length; i++) {
			result[i] = indices[i];
		}

		return result;
	}

}
