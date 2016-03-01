package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import math.Vector3f;
import render.Mesh;
import render.Vertex;

public class RessourceLoader {

	public static String loadShader(String fileName) {

		StringBuilder shaderSource = new StringBuilder();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./res/shaders/" + fileName));
			String line;

			while ((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Could not read File");
			e.printStackTrace();
			System.exit(1);
		}

		return shaderSource.toString();

	}

	public static Mesh loadMesh(String fileName) {

		String[] splitArray = fileName.split("\\.");
		String ext = splitArray[splitArray.length - 1];

		if (!ext.equals("obj")) {
			System.err.println("Error: Fileformat not supported for Mesh: " + ext);
			System.exit(1);
		}

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();

		BufferedReader meshReader = null;

		try {
			meshReader = new BufferedReader(new FileReader("./res/models/" + fileName));
			String line;

			while ((line = meshReader.readLine()) != null) {
				String[] tokens = line.split(" ");
				tokens = Utils.removeEmptyStrings(tokens);

				if (tokens.length == 0 || tokens[0].equals("#"))
					continue;
				else if (tokens[0].equals("v")) {
					vertices.add(new Vertex(new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]),
							Float.valueOf(tokens[3]))));
				}
				// else if(tokens[0].equals("vt"))
				// {
				// m_texCoords.add(new Vector2f(Float.valueOf(tokens[1]),
				// 1.0f - Float.valueOf(tokens[2])));
				// }
				// else if(tokens[0].equals("vn"))
				// {
				// m_normals.add(new Vector3f(Float.valueOf(tokens[1]),
				// Float.valueOf(tokens[2]),
				// Float.valueOf(tokens[3])));
				// }
				else if (tokens[0].equals("f")) {
					int x = Integer.parseInt(tokens[1])-1;
					int y = Integer.parseInt(tokens[2])-1;
					int z = Integer.parseInt(tokens[3])-1;
					indices.add(x);
					indices.add(y);
					indices.add(z);
				}
			}

			meshReader.close();
			
			Mesh res = new Mesh();
			
			Vertex[] vertexData = new Vertex[vertices.size()];
			vertices.toArray(vertexData);
			
			Integer[] indexData = new Integer[indices.size()];
			indices.toArray(indexData);
			res.addVertices(vertexData, Utils.toIntArray(indexData));
			
			
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		
		System.err.println("were in the void.... this should never happen...");
		System.exit(1);
		return null;

	}

}
