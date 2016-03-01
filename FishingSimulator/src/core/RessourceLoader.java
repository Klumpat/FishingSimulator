package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RessourceLoader {
	
	public static String loadShader(String fileName){
		
		StringBuilder shaderSource = new StringBuilder();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./res/shaders/"+fileName));
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

}
