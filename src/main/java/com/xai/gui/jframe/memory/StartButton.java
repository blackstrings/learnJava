package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StartButton extends JButton {

	public StartButton(){
		setBackground(Color.GRAY);
		String startBtnTxt = "<html><font color=gray size=+1>START</font></html>";
		add(new JLabel(startBtnTxt) );
		//startBtn.setForeground(Color.WHITE);
		setPreferredSize(new Dimension(100,30));
		setOpaque(false);
		
	}
}
