package com.xai.openGL;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jogamp.opengl.swt.GLCanvas;

/**
 * Tutorial intro into OpenGL
 * link: https://open.gl/context
 * @author xlao
 *
 */
public class OpenGLIntro {

	public OpenGLIntro(){
		//before you can start drawing anything you need to initialize OpenGL
		//this is done by creating an OpenGL context
		
		//problem is that that creating a window and an OpenGL context 
		//is not part of the OpengGL specification 
		//which is why it is done differently on every platform out there
		
		//the flow is similar for any platform
		//define the properties of the draw window (title, size, OpenGL context properties)
		
	}
	
	
	
	public static void main(String [] args){
		//psuedo code of OpenGL
		//---------------------
		/*
		createWidow(title, width, height);
		createOpenGLContext(settings);
		
		while(windowOpen){
			while (event = newEvent()){
				handleEvent(event);
			}
			
			updateScene();
			
			drawGraphics();
			presentGraphics();
			
		}
		
		return 0;
		
		 */
		
		//GLCanvas canvas = new GLCanvas();
		
	}
	
	
}
