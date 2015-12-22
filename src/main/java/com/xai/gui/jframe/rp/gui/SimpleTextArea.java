package com.xai.gui.jframe.rp.gui;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class SimpleTextArea extends JTextArea {
	
	public SimpleTextArea(String text, int row, int col, int padding){
		super(text, row, col);
		
		setLineWrap( true );
		setWrapStyleWord(true);
		setBorder(BorderFactory.createCompoundBorder(
				this.getBorder(),
				BorderFactory.createEmptyBorder(padding,padding,padding,padding)));
		
	}
	
}
