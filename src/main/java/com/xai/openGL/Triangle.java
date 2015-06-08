package com.xai.openGL;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Triangle {
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

    protected static void render( GL2 gl2, int width, int height ) {
    	//color white: 1,1,1
    	//color black: 0,0,0
    	
    	gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
        // draw a triangle filling the window
        gl2.glLoadIdentity();
        
    	
        
    	//matrix sample, you can't see anything with this one though as too small
    	//-------------------------------------------------------------------------
    	/*
        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();
        
        gl2.glTranslated(1,2,3);
        gl2.glScaled(200, 200, 200);
        
        gl2.glBegin(GL2.GL_POINTS);
        {
        	gl2.glColor3f(1, 1, 1);
        	gl2.glVertex3f(1,1,1);
        }
        gl2.glEnd();
        */
    	
    	
        
        //circle
        //if you cannot see the draw is probably too small
    	//-------------------------------------------------------------------------
        /*
        float scale = 300f;
        gl2.glBegin(GL2.GL_LINE_LOOP);
        gl2.glColor3f(1f, 1f, 1f);
        for(int i=0;i<256;i++)
        {
         double theta = 2*i*Math.PI/256;
         double y = scale * Math.sin(theta);
         double x = scale * Math.cos(theta);
         gl2.glVertex2d(x,y);
        }
        gl2.glEnd();
        */
        
        
    	//the tehedron triangle - can't see cause too small
    	//-------------------------------------------------------------------------
        /*
        float scale = 500f;
        gl2.glBegin(GL2.GL_TRIANGLES);
        {
         gl2.glColor3f(1.0f, 0.5f, 0.5f);
         gl2.glVertex3f( 0.0f * scale, 0.5f * scale, 0.0f * scale);
         gl2.glVertex3f(-0.25f * scale, 0.0f * scale, 0.0f * scale);
         gl2.glVertex3f( 0.25f * scale, 0.0f * scale, 0.0f * scale);
         
         gl2.glColor3f(0.5f, 1.0f, 0.5f);
         gl2.glVertex3f( -0.25f * scale, 0.0f * scale, 0.0f * scale);
         gl2.glVertex3f( -0.5f * scale, -0.5f * scale, 0.0f * scale);
         gl2.glVertex3f( 0.0f * scale, -0.5f * scale, 0.0f * scale);
         
         gl2.glColor3f(0.5f, 0.5f, 1.0f);
         gl2.glVertex3f( 0.25f * scale, 0.0f * scale, 0.0f * scale);
         gl2.glVertex3f( 0.0f * scale, -0.5f * scale, 0.0f * scale);
         gl2.glVertex3f( 0.5f * scale, -0.5f * scale, 0.0f * scale);
        }
        gl2.glEnd();
        */
        
        //rainbow triangle, each vertex number is 1 pixel
    	//-------------------------------------------------------------------------
        
        gl2.glBegin( GL2.GL_TRIANGLES );
        
        gl2.glColor3f( 1, 0, 0 );
        gl2.glVertex2f( 0, 0 );
        
        gl2.glColor3f( 0, 1, 0 );
        gl2.glVertex2f( width, 0 );
        
        gl2.glColor3f( 0, 0, 1 );
        gl2.glVertex2f( width / 2, height );
        
        gl2.glEnd();
        
        
        
        
        
        
    }
}