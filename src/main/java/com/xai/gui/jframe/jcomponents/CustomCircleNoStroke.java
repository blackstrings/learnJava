package com.xai.gui.jframe.jcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

//Be caution of using paintComponent vs paintComponents with 's'
//usually you want to use the one without the s
//the one with the s seems to have more advance setup for it to display properly
public class CustomCircleNoStroke extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	public CustomCircleNoStroke(int width, int height){
		this.width = width;
		this.height = height;
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		g.setColor(Color.red);
		g.fillOval(0, 0, width, height);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}
}
