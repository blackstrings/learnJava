package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MemFrame extends JFrame {

	
	
	public MemFrame(){
		init();
		loadWelcomeScreen();
	}
	
	public void init(){
		setTitle("Memory");
		Dimension mainSize = new Dimension(200,200);
		setSize(mainSize);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
	}
	
	public void loadWelcomeScreen(){
		JPanel layoutPanel = new JPanel(new BorderLayout());
		layoutPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		layoutPanel.setBackground(Color.BLACK);
		this.add(layoutPanel);
		
		//title
		String text1 = "<html><font size=+2 color=red>The</font> <font color=white>Memory</font></html>";
		JLabel title = new JLabel(text1);
		title.setPreferredSize(new Dimension(this.getWidth(), 50));
		title.setBackground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		//title.setFont(new Font("Serif", Font.BOLD, 10));
		layoutPanel.add(title, BorderLayout.NORTH);
		
		//copryright
		String text2 = "<html><font color=white> copyright&copy;2015 </font></html>";
		JLabel copyright = new JLabel(text2);
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		layoutPanel.add(copyright, BorderLayout.SOUTH);
		
		//start button
		JButton startBtn = new JButton("Start");
		startBtn.setPreferredSize(new Dimension(50,10));
		layoutPanel.add(startBtn, BorderLayout.CENTER);
		
		
	}
	
	
	
}
