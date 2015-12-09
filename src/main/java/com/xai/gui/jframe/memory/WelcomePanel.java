package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	
	//the constructor takes in a action listener for
	//its only button, the play button
	public WelcomePanel(ActionListener playBtnActionListener){
		super(new BorderLayout());
		setBackground(Color.BLACK);
		
		//title
		String titleText = "<html><font size=+2 color=white>The</font> <font color=red>Memory</font></html>";
		TitleLabel title = new TitleLabel(titleText);
		this.add(title, BorderLayout.NORTH);
		
		//start button
		BasicButton playBtn = new BasicButton("Play");
		playBtn.addActionListener(playBtnActionListener);
		
		//we don't want start button to stretch across the entire screen
		//so we create a seperate panel for start button
		//if startBtn is inside its own panel, it won't stretch
		JPanel playBtnPanel = new JPanel(new FlowLayout()){
			//background image
			public void paintComponent(Graphics g){
				ImageIcon img = new ImageIcon("src/main/java/com/xai/gui/jframe/memory/bg1.png");
				g.drawImage(img.getImage(), 50, 20, null);
			}
			public Dimension getPreferredSize(){
				return new Dimension(50,50);
			}
		};
		
		playBtnPanel.add(playBtn);
		//playBtnPanel.setVisible(true);
		this.add(playBtnPanel, BorderLayout.CENTER);
		
		//copyright text for bottom of screen
		String text2 = "<html><font color=gray> copyright&copy;2015 </font></html>";
		CopyrightLabel copyright = new CopyrightLabel(text2);
		this.add(copyright, BorderLayout.SOUTH);
	}
	
}
