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

	JLabel timerJLabel;
	int counter;
	Timer timer;
	
	public TimerPanel(){
		super(new FlowLayout(0));
		setBackground(Color.GRAY);
		
		timerJLabel = new JLabel("0");
		timerJLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		add(timerJLabel);
		
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				updateText();
				if(counter > 10){
					timer.stop();
					timer = null;
				}
			}
		});
		timer.start();
	}
	
	private void updateText(){
		timerJLabel.setText(""+counter);
	}
}
