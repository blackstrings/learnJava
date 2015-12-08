package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

//container that holds the 3 color buttons user can press (red, gree, blue)
public class FooterPanel extends JPanel {

	JButton redBtn;
	JButton greenBtn;
	JButton blueBtn;
	
	public FooterPanel(){
		super(new FlowLayout());
		init();
	}
	
	private void init(){
		//red
		redBtn = new ColorButton(Color.RED,0);
		add(redBtn);
		
		//green
		greenBtn = new ColorButton(Color.GREEN,1);
		add(greenBtn);
		
		//blue
		blueBtn = new ColorButton(Color.BLUE,2);
		add(blueBtn);
		
		
	}
	
	//GETTERS
	// we decide to not have setters
	// these buttons will have to be set at constructor time only
	public JButton getRedBtn() {
		return redBtn;
	}

	public JButton getGreenBtn() {
		return greenBtn;
	}

	public JButton getBlueBtn() {
		return blueBtn;
	}

}
