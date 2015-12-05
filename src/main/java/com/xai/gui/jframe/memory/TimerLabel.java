package com.xai.gui.jframe.memory;

import javax.swing.JLabel;

public class TimerLabel extends JLabel {

	
	public TimerLabel(){
		setText("Time Left:0");
	}
	
	public void setTimerText(String timeLeft){
		setText(timeLeft);
	}
	
	
	
}
