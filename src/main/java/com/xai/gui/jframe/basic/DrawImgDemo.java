package com.xai.gui.jframe.basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * one way to read in image from file
 *
 */
public class DrawImgDemo extends JFrame {

	private Dimension size;
	BufferedImage bufferImg;
	BufferedImage resizedBufferImg;
	
	public DrawImgDemo(){
		init();
		loadScreen();
	}
	
	public static void main(String [] args){
		//use this method to invoke jframe so setvisible is called last
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	DrawImgDemo demo = new DrawImgDemo();
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
		//get the source
		try {
			bufferImg = ImageIO.read(new File("res/images/icon1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//resize if needed
		//resizedBufferImg = resizeImage(bufferImg, 50, 50, BufferedImage.TYPE_INT_ARGB);
	
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				//draw as many as you want giving differetn coordinates each time
				g2d.drawImage(bufferImg, 0, 0, null);
				g2d.drawImage(bufferImg,30, 0, null);
				g2d.drawImage(bufferImg,60, 0, null);
				//close the drawing session
				g2d.dispose();
			}
		};
		
		panel.setBackground(Color.BLACK);
		
		//creates border
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		this.add(panel);

	}
	
	//not really working
	private BufferedImage resizeImage(BufferedImage originalImage, int width,
            int height, int type) throws IOException {

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }
	
	
}
