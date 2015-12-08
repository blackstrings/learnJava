package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BasicButton extends JButton {

	public BasicButton(String buttonName){
		setBackground(Color.GRAY);
		String startBtnTxt = "<html><font color=gray size=+1>" + buttonName + "</font></html>";
		JLabel label = new JLabel(startBtnTxt);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		//startBtn.setForeground(Color.WHITE);
		setPreferredSize(new Dimension(100,30));
		setOpaque(false);
		
	}
}
