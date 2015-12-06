package com.xai.gui.jframe.sonygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FlashFrame extends JFrame {
	
	public FlashFrame(){
		setTitle("Flash");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Window cannot be stretched
		setResizable(false);
		setVisible(true);
		// The JPanel
		getContentPane().setBackground(Color.BLACK);
		
		loadWelcomeScreen();
		
	}
	
		public void loadWelcomeScreen(){
			BorderLayout myBorder = new BorderLayout();
			JPanel borderPanel = new JPanel(myBorder);
			JLabel label = new JLabel("Welcome To Flash");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			borderPanel.add(label, BorderLayout.CENTER);
			
			
			// The Start button 
			// ---------------------------------------------------------------------------
			JButton startButton = new JButton("Start");
			borderPanel.add(startButton, BorderLayout.SOUTH);
			
			startButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					startGame();
					
				}
			});
			// -----------------------------------------------------------------------------
			
			// Add panel to the JFrame
			this.add(borderPanel);
			
	
		}
		
		public void startGame(){
			
			//loadRound();
			// String userInput = JOptionPane.showInputDialog("Hello World");
			// System.out.println(userInput);
		}
			
	 

}
