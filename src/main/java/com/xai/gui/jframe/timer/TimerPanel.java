package com.xai.gui.jframe.timer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerPanel extends JPanel{

	JLabel timerText;
	int time;
	Timer timer;
	
	public TimerPanel(){
		super(new FlowLayout(0));
		setBackground(Color.GRAY);
		
		timerText = new JLabel("0");
		timerText.setBorder(BorderFactory.createLineBorder(Color.RED));
		add(timerText);
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time++;
				updateText();
				if(time > 10){
					timer.stop();
					timer = null;
				}
			}
		});
		timer.start();
	}
	
	private void updateText(){
		timerText.setText(""+time);
	}
}
