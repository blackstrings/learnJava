package com.xai.gui.jframe.timer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//the idea is to put the timer itself in the panel that it will be affecting.
public class TimerDemo extends JFrame {

	public TimerDemo(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(150, 100);
		init();
	}
	
	private void init(){
		TimerPanel pnl = new TimerPanel();
		add(pnl);
	}
	
	public static void main(String [] args){
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	TimerDemo demo = new TimerDemo();
            	demo.setVisible(true);
            }
        });
	}
}
