package com.xai.gui.jframe.simple;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class CustomComp extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	public CustomComp(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);	//make sure htis dymension is bigger than the drawRect dimension
    }
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(0,0, width-1, height-1);	//because the dimension is 50,50, the offset is 1 pixel off
		
		
	}
	
}
