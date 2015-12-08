package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

//this class will render the color that are pressed in the display view
public class ColorGraphicIcon extends JComponent {

	private Color color;
	private int width = 30;
	private int height = 30;
	
	public ColorGraphicIcon(Color color){
		this.color = color;
	}
	
	public ColorGraphicIcon(int id){
		switch(id){
		case 0:
			this.color = Color.RED;
			break;
		case 1:
			this.color = Color.GREEN;
			break;
		case 2:
			this.color = Color.BLUE;
			break;
		default:
			this.color = Color.RED;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(color);
		g.fillOval(0, 0, width, height);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width,height);
	}
}
