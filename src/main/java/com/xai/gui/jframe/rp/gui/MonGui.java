package com.xai.gui.jframe.rp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import com.xai.gui.jframe.rp.domain.Mon;

public class MonGui extends JComponent {

	private Mon mon;
	private int wid = 50;
	private int hei = 50;
	
	public MonGui(Mon mon){
		this.mon = mon;
		setBorder(BorderFactory.createLineBorder(Color.gray));
	}
	
	public Mon getMon(){
		return mon;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, wid, hei);
		g.setColor(Color.white);
		g.drawString(String.valueOf(mon.getId()), 5, 15);
	}
	
	public void paintComponent(Graphics g, int x, int y){
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y, wid, hei);
		g.setColor(Color.white);
		g.drawString(String.valueOf(mon.getId()), x+5, y+15);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(wid, hei);
	}
}
