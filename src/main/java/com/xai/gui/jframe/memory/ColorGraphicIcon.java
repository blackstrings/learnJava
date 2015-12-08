package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

//this class will render the color that are pressed in the display view
public class ColorGraphicIcon extends JComponent {

	Color color;
	
	public ColorGraphicIcon(Color color){
		this.color = color;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(color);
		g.fillRect(0, 0, 50, 50);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(50,50);
	}
}
