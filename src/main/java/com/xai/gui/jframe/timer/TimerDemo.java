package com.xai.gui.jframe.timer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.xai.gui.jframe.basic.DrawImgDemo;

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
