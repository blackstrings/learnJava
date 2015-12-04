package com.xai.gui.jframe.jcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JFrame
 * 		JPanel(choose a border layout)
 * 			JComponent
 * 			JButton
 * 			JText
 * 
 * Only one JFrame per app for simplicity
 * 
 * @author xlao
 *
 */
public class MyComponentDemo {

	static class Compy extends JComponent{
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(Color.WHITE);
			g2.drawOval(10, 10, 100, 100);
			
		}
		
		public Dimension getPreferredSize(){
			
			return new Dimension(100,100);
		
		}
		
	}
	
	public static void main(String [] args){
		
		
		Compy comp = new Compy();
		
		
		JPanel pnl = new JPanel();
		pnl.setSize(200,200);
		pnl.setBackground(Color.BLUE);
		
		JLabel label = new JLabel("Test");
		//pnl.add(label);
		
		pnl.add(comp);
		
		
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(pnl);
		frame.add(label);
		
		frame.setVisible(true);
		
		
		
		
	}
	
	
}
