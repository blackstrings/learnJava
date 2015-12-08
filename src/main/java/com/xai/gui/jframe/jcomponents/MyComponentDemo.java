package com.xai.gui.jframe.jcomponents;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JFrame
 * 		JPanel(choose a border layout)	- must render all pixels in its bounding box
 * 			JComponent	- doesn't have to render all pixel in its bounding box
 * 			JLabel - is a JComponent
 * 			JButton
 * 			JText
 * 
 * Only one JFrame per app for simplicity
 * Be caution of using paintComponent vs paintComponents with 's'
 * usually you want to use the one without the s
 * the one with the s seems to have more advance setup for it to display properly
 *
 */
public class MyComponentDemo extends JFrame{
	
	public MyComponentDemo(int w, int h){
		setSize(w,h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String [] args){
		
		MyComponentDemo frame = new MyComponentDemo(400,400);
		
		JPanel pnl = new JPanel(new BorderLayout());
		frame.add(pnl);
		pnl.setSize(frame.getWidth(),frame.getHeight());
		pnl.setBackground(Color.GRAY);
		
		JLabel label = new JLabel("Test");
		pnl.add(label, BorderLayout.NORTH);
		
		CustomCircleWithStroke circWithStroke = new CustomCircleWithStroke(100,100,10);
		pnl.add(circWithStroke, BorderLayout.CENTER);
		
		CustomCircleNoStroke circNoStroke = new CustomCircleNoStroke(100, 100);
		pnl.add(circNoStroke, BorderLayout.SOUTH);
		
		
		frame.setVisible(true);
	}
	
	
}
