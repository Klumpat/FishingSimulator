package render;

import org.lwjgl.opengl.GL11;

public class Texture {

	private int id;

	public Texture(int ID) {
		this.id = id;
	}

	public void bind(){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}
	
	public int getId() {
		return id;
	}
	
	

}
