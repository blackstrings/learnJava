package com.xai.gui.jframe.basic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * one way to read in image from file
 *
 */
public class DrawImgAnimationDemo extends JFrame {

	private Dimension size;
	
	
	public DrawImgAnimationDemo(){
		init();
		loadScreen();
	}
	
	public static void main(String [] args){
		//use this method to invoke jframe so setvisible is called last
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	DrawImgAnimationDemo demo = new DrawImgAnimationDemo();
            	demo.setVisible(true);
            }
        });
	}
	
	public void init(){
		size = new Dimension(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("test");
		setSize(size);
	}
	
	private void loadScreen() {
		
		AnimSprite sprite = new AnimSprite();
		
		JPanel gl = new JPanel(new GridLayout(0,2));
		gl.add(sprite);
		this.add(gl);

	}
	
	private static class AnimSprite extends JComponent{
		
		private BufferedImage bufferImg;
		private int x = 0;
		
		public AnimSprite(){
			
			//load the image
			try {
				bufferImg = ImageIO.read(new File("res/images/icon1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//create the timer to simulate fps
			Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                	//updates and redraws this component
                    repaint();
                    x += 5;
                }
            });
            timer.start();
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			//to draw the loaded image
			Graphics2D g2d = (Graphics2D) g.create();

			//the key here is the x, as timer triggers, the x will increment
			//thus x has a new value each repaint
			g2d.drawImage(bufferImg, x, 0, null);
			//close the drawing session
			g2d.dispose();
		}
	}
	
	
}
