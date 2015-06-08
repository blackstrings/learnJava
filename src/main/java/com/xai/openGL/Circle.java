package com.xai.openGL;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Circle {
    protected static void draw( GL2 gl2, int width, int height ) {
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );
        
        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
    }

    protected static void render( GL2 gl2, int width, int height ) {
    	//color white: 1,1,1
    	//color black: 0,0,0
    	
    	gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
        // draw a triangle filling the window
        gl2.glLoadIdentity();
        
        //circle
        //if you cannot see the draw is probably too small
    	//-------------------------------------------------------------------------
        
        float scale = 100f;
        
        //offset center of the circle from bottom left corner
        float offSetX = width/2;
        float offSetY = height/2;
        
        gl2.glBegin(GL2.GL_LINE_LOOP);
        gl2.glColor3f(1f, 1f, 1f);
        for(int i=0;i<256;i++)
        {
        	double theta = 2*i*Math.PI/256;
        	double y = scale * Math.sin(theta);
        	double x = scale * Math.cos(theta);
        	gl2.glVertex2d(x+offSetX,y+offSetY);
        }
        gl2.glEnd();
        
        
        
        
        
        
        
    }
}