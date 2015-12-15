package com.xai.gui.jframe.events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class CustBtn extends JComponent {

	public CustBtn(){
		setBorder(BorderFactory.createLineBorder(Color.RED));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(0, 0, 50, 50);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, 50, 50);
		
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(50,50);
	}
}
