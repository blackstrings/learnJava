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
		
		//the timer's 1st argument takes in milliseconds
		//so 1000 = 1 sec, 2000 = 2 second, 1500 = 1.5 seconds, etc
		//the 2nd argurment is a actionListener we can define
		//what you see here is the shortcut way to add a new actionListener as an argument
		//it is faster way to add new objects inside arguments instead of creating
		//ActionListener myActionList = new ActionListener() then passing ref into the 2nd argument
		timer = new Timer(1000, new ActionListener() {
			//override this method to take control of what happens when timer counts to zero
			public void actionPerformed(ActionEvent e) {
				//-----------------------------
				//do whatever we want in here
				counter++;
				
				updateText();
				
				//we sstop the timer when the counter reaches 10
				if(counter > 10){
					//if you don't stop the timer, the event
					//will continue to trigger every 1000 milliseconds, which is 1 second
					timer.stop();
					//this is optional
					timer = null;
				}
				//--------------------------
			}
		});
		
		//don't forget to start the timer in order for it to trigger the event above
		//when it reaches zero
		//if you don't start the timer, the event will never get trigger
		timer.start();
	}
	
	private void updateText(){
		timerJLabel.setText(""+counter);
	}
}
