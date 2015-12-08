package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TitleLabel extends JLabel {

	public TitleLabel(String text){
		super(text);
		setPreferredSize(new Dimension(this.getWidth(), 50));
		setBackground(Color.BLUE);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.BOTTOM);
		
		//only if you want this title to have a new font type and size
		//title.setFont(new Font("Serif", Font.BOLD, 10));
	}
}
