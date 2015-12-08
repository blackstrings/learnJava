package com.xai.gui.jframe.jcomponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

/**
 * extend a JComponent vs JPanel when you want transparent background or
 * do not want to fill the whole boundary with an opaque color
 * JComponent doesn't require you fille the whole boundary with a color
 *
 *
 */
public class CustomCircleWithStroke extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	int strokeSize;
	
	public CustomCircleWithStroke(int width, int height, int strokeSize){
		this.width = width;
		this.height = height;
		this.strokeSize = strokeSize;
	}
	
	//Be caution of using paintComponent vs paintComponents with 's'
	//usually you want to use the one without the s
	//the one with the s seems to have more advance setup for it to display properly
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		//if you want to use graphics2D methods (which you have to cast g to use 2d)
		//Graphics2D has the method to change stroke size
		Graphics2D g2 = (Graphics2D) g.create();
		//anti-alias
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.WHITE);
		g2.setStroke(new BasicStroke(strokeSize));
		//note that the stroke size will need to offset x,y to not get clipping
		//account for stroke size to render within the boundary
		g2.drawOval(strokeSize/2, strokeSize/2, width-strokeSize, height-strokeSize);
		/*
		g2.drawOval(getInsets().left, 
				getInsets().top, 
				width - getInsets().left - getInsets().right, 
				height - getInsets().top - getInsets().bottom);
		*/
		
		
		//if you want to use default graphics method only and not modify stroke
		/*
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 100, 100);
		g.setColor(Color.RED);
		g.drawOval(0, 0, 100, 100);
		*/
		
	}
	
	//override this method if you want the component to have a default size when created
	public Dimension getPreferredSize(){
		return new Dimension(width,height);
	}
	
}
