package com.xai.openGL;

import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Image {
	
	private static Texture text = null;
	private static IntBuffer buffer;
	
    protected static void setup( GL2 gl2, int width, int height ) {
        
    	gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
        
    	 // coordinate system origin at lower left with width and height same as the window
       
        try{
        String filename = "res/images/img2.png";
//        text = TextureIO.newTexture();
        	BufferedImage textureImage = ImageIO.read(new File(filename));
        	//float[] pixels = textureImage.getgetPixels(0, 0, 256, 256, null);
        	
        	buffer = IntBuffer.allocate(textureImage.getWidth() * textureImage.getHeight());
        	
        	gl2.glTexImage2D(GL2.GL_TEXTURE_2D, 0, GL.GL_RGB, 256, 256, 0, GL.GL_RGBA, gl2.GL_UNSIGNED_BYTE, buffer);
        	
        	/*
        	double dukeWidth = 256.0;
        	double dukeHeight = 256.0;
        	WritableRaster raster =  Raster.createInterleavedRaster (DataBuffer.TYPE_BYTE,
        		                                    dukeWidth,
        		                                    dukeHeight,
        		                                    4,
        		                                    null);
        	
        	ComponentColorModel colorModel= new ComponentColorModel (ColorSpace.getInstance(ColorSpace.CS_sRGB),
        		                             new int[] {8,8,8,8},
        		                             true,
        		                             false,
        		                             ComponentColorModel.TRANSLUCENT,
        		                             DataBuffer.TYPE_BYTE);		
        		
        	BufferedImage dukeImg = new BufferedImage (colorModel,
        		                       raster,
        		                       false,
        		                       null);
        		
        	Graphics2D g = dukeImg.createGraphics();
        		AffineTransform gt = new AffineTransform();
        		
			gt.translate (0, dukeHeight);
    		gt.scale (1, -1d);
    		g.transform (gt);
    		g.drawImage (i, null, null);
        */
        	
        }catch(GLException gle){
        	
        }catch(IOException e){
        	e.getStackTrace();
        }
        
        
        
    	/*
    	 // Load earth texture.
        try {
            InputStream stream = getClass().getResourceAsStream("earth.png");
            TextureData data = TextureIO.newTextureData(stream, false, "png");
            earthTexture = TextureIO.newTexture(data);
        }
        catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
        */
        
    }

    protected static void render( GL2 gl2, int width, int height ) {
    	//color white: 1,1,1
    	//color black: 0,0,0
    	
    	gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
        // draw a triangle filling the window
        gl2.glLoadIdentity();
        
        //rainbow triangle, each vertex number is 1 pixel
    	//-------------------------------------------------------------------------
        
      
        gl2.glBegin( GL2.GL_QUADS);
        {
	        gl2.glColor3f( 1, 0, 0 );
	        
	        gl2.glTexCoord2f(0 , 0);
	        gl2.glVertex2f( 0, 0 );
	        
	        gl2.glTexCoord2f(1, 0);
	        gl2.glVertex2f( width/2, 0 );
	        
	        gl2.glTexCoord2f(1, 1);
	        gl2.glVertex2f( width/2, height/2 );
	        
	        gl2.glTexCoord2f(0, 1);
	        gl2.glVertex2f( 0, height/2 );
	        
        }
        gl2.glEnd();
        
        
        
        
        
        
        
    }
}