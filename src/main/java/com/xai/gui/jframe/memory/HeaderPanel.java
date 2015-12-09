package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {

	private JLabel timerLabel;
	private JLabel roundLabel;
	
	public HeaderPanel(int time, int round){
		super(new BorderLayout());	//we force this header panel to have a border layout
		init(time, round);
	}
	
	private void init(int time, int round){
		
		//example - Time Rem: 55
		//-----------------------------------------
		//left side is timer label
		timerLabel = new JLabel();
		setTimerLabel(time);
		add(timerLabel, BorderLayout.WEST);
		//-----------------------------------------
		
		//example - Round: 5
		//-----------------------------------------
		roundLabel = new JLabel();
		setRoundLabel(round);
		add(roundLabel, BorderLayout.EAST);
		//-----------------------------------------
	
	}
	
	//call this method as the only way to change the timer label text
	public void setTimerLabel(int value){
		String text = "<html><font size=+1>Time Rem: " + value + "</font></html>";
		timerLabel.setText(text);
	}
	
	public void setRoundLabel(int value){
		String text = "<html><font size=+1>Round " + value + "</font></html>";
		roundLabel.setText(text);
	}
	
}
