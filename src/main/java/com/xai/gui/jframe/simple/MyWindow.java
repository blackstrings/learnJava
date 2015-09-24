package com.xai.gui.jframe.simple;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class MyWindow extends JFrame {

	public MyWindow(String windowName){
		super(windowName);
		this.setSize(400,400);
		//this.setBackground(new Color(0,0,0));
		
		//centers the Jframe, otherwise it will start or appear in upper left corner
		setLocationRelativeTo(null);
		
		//by default the close X button just hides the frame
		//we set it to exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//makes the jframe visible, by default it's false
		setVisible(true);
		
	}
	
}
