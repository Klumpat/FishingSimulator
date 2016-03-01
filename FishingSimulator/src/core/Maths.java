package core;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class Maths {
	
	public static Matrix4f initTranslationMatrix(float x, float y, float z){
		
//		Matrix4f tm = new Matrix4f();
//		tm.setIdentity();
//	
//			tm.m00 = 1; 	tm.m01 = 0; 	tm.m02 = 0; 	tm.m03 = x;
//			tm.m10 = 0; 	tm.m11 = 1; 	tm.m12 = 0; 	tm.m13 = y;
//			tm.m20 = 0; 	tm.m21 = 0; 	tm.m22 = 1; 	tm.m23 = z;
//			tm.m30 = 0; 	tm.m31 = 0; 	tm.m32 = 0; 	tm.m33 = 1;
//	
//		return tm;
		
		
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(new Vector3f(x,y,z), matrix, matrix);
		return matrix;
	}
	
	

}
