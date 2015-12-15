package com.xai.gui.jframe.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventsDemo extends JFrame {
	
	public EventsDemo(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		
		JButton btn = new JButton("Test Btn");
		//add actionlistener to btn
		BeepActionListener beepAL = new BeepActionListener(btn);
		
		//make a quick panel for btn to be in
		JPanel pnl = new JPanel();
		pnl.add(btn);
		
		CustBtn custBtn = new CustBtn();
		custBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("moust click");
				
			}

			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		pnl.add(custBtn);
		add(pnl);
		
	}

	public static void main(String[] args){
		
		
		
		EventsDemo frame = new EventsDemo();
		frame.setVisible(true);
		
	}
}
