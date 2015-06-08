package com.xai.openGL;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.awt.GLCanvas;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * A minimal program that draws with JOGL in an AWT Frame.
 *
 * @author Wade Walker
 */
public class DemoAWT {

    public static void main( String [] args ) {
        GLProfile glprofile = GLProfile.getDefault();
        GLCapabilities glcapabilities = new GLCapabilities( glprofile );
        final GLCanvas glcanvas = new GLCanvas( glcapabilities );

        glcanvas.addGLEventListener( new GLEventListener() {
            
        	//whenever the canvas is resized, important for the camera angle
        	//whenever the width/height ratio changes
            @Override
            public void reshape( GLAutoDrawable glautodrawable, int x, int y, int width, int height ) {
                //Square.setup( glautodrawable.getGL().getGL2(), width, height );
            	
            	
            }
            
            //Implement to initialize OpenGL
            //called by AWT event queue as son as the window is ready
            //set global settings here
            @Override
            public void init( GLAutoDrawable glautodrawable ) {
            	Image.setup( glautodrawable.getGL().getGL2(), 256, 256);

            }
            
            @Override
            public void dispose( GLAutoDrawable glautodrawable ) {
            }
            
            //Implement to draw stuff
            //called for every re-rendering of the scene
            @Override
            public void display( GLAutoDrawable glautodrawable ) {
                //Square.render( glautodrawable.getGL().getGL2(), 1, 1, 200, 100,200 );
            	Image.render( glautodrawable.getGL().getGL2(), 256, 256);
            }
            
            //Implement to deal with GLCanvas’s resizing.
            //resize
        });

        final Frame frame = new Frame( "One Triangle AWT" );
        frame.add( glcanvas );
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent windowevent ) {
                frame.remove( glcanvas );
                frame.dispose();
                System.exit( 0 );
            }
        });

        frame.setSize( 640, 480 );
        frame.setVisible( true );
    }
}