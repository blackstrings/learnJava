package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class ColorButton extends JButton {

	private Color color;
	private int id;
	
	public ColorButton(Color color, int id){
		this.color = color;
		this.id = id;
		setBackground(color);
		setPreferredSize(new Dimension(50,20));
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
}
