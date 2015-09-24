package com.xai.gui.jframe;

import javax.swing.JButton;

public class CustomJButton extends JButton {

	public CustomJButton(String name, int xPos, int yPos, int width, int height){
		super(name);
		if(xPos != 0 && yPos != 0){
			this.setBounds(xPos, yPos, width, height);
		}else{
			this.setSize(width, height);
		}
	}
	
}
