#version 330

in vec2 out_texCoord0;

uniform vec3 color;
uniform sampler2D sampler;

void main(){
	
	vec4 textureColor = texture2D(sampler, out_texCoord0.xy);
	
	if(textureColor == 0){
		gl_FragColor = vec4(color,1.0);
	} else {
		gl_FragColor = textureColor * vec4(color,1.0);
	}



};