package com.xai.gui.jframe.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JButtonDemo extends JFrame {

	public JButtonDemo(){
		//basic jframe setup
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Button Demo");
		setSize(150, 100);
		init();
	}
	
	private void init(){
		//panel for button to be inside in
		JPanel pnl = new JPanel();
		
		//create button
		JButton btn = new JButton("Hello Btn");
		
		//create action listener - it defines what happens when button is clicked
		ActionListener al = new ActionListener() {
			//we override the method this like this
			public void actionPerformed(ActionEvent e) {
				//we can put anything we want to happen in here
				//such as calling sys out print or other methods
				//--------------------------------------------------
				System.out.println("Hello button was clicked");
				
				//--------------------------------------------------
			}
		};
		
		//hook up the button by adding the action listener to button
		btn.addActionListener(al);
		
		//add button to panel
		pnl.add(btn);
		
		//add panel to frame
		this.add(pnl);
		
		//that's it, now run the main method
	}
	
	public static void main(String[] args){
		JButtonDemo demo = new JButtonDemo();
		demo.setVisible(true);	//always call this last to display the frame
	}
}
