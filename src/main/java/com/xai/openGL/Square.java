package com.xai.openGL;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Square {
    protected static void setup( GL2 gl2, int width, int height ) {
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
    }

    protected static void render( GL2 gl2, int width, int height, int scale, float x, float y) {
    	//color white: 1,1,1
    	//color black: 0,0,0
    	
    	gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
    	
    	gl2.glPushMatrix();
    	
    	gl2.glLoadIdentity(); // reset the current model view matrix
    	
    	gl2.glTranslatef(x,y,0);
    	gl2.glScaled(scale, scale, scale);
    	gl2.glRotated(30, 0, 0, 0);
        
    	//begin drawing
        gl2.glBegin( GL2.GL_QUADS );
        //you don't need the bracket but it helps visually
        {
	        gl2.glColor3f( 1, 0, 0 );	//set new color of every pixel from here on
	        gl2.glVertex2f( 0, 0 );
	        
	        gl2.glColor3f( 0, 1, 0 );	//change the pixel color from here on
	        gl2.glVertex2f( width, 0 );
	        
	        gl2.glColor3f( 0, 0, 1 );	//change the pixel color from here on
	        gl2.glVertex2f( width, height );
	        
	        gl2.glColor3f(0, 1, 0);
	        gl2.glVertex2f(0,height );
        }
        
        gl2.glEnd();
        
        
        gl2.glPopMatrix();
        
        
        
        
        
    }
}