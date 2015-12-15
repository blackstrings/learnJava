package com.xai.gui.jframe.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//the button component should be passed into this
public class BeepActionListener implements ActionListener {

	public BeepActionListener(JButton btn){
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Beeped");
	}
	
}
