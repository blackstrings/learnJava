package com.xai.gui.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * JavaFX is the newer GUI standard, where Swing and SWT SPI are the old ones.
 * @author xlao
 *
 */
public class JFrameDemo2 extends JFrame {

	private JTextPane mainTextPane;
	
	public JFrameDemo2(){
		initUI();
	}
	
	private void initUI(){
		//main window container
		setTitle("JFrame Example 2");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainTextPane = new JTextPane();
		mainTextPane.setText("This is some text");
		
		//button
		JButton button = new JButton("Test");
		int width = 100;
		int height = 30;
		int xPos = 100;
		int yPos = 100;
		button.setBounds(xPos, yPos, width, height);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainTextPane.setText("This is new text you see");
			}
		});
		
		JPanel panel = new JPanel(new GridLayout());
		panel.add(button);
		panel.setAlignmentX(LEFT_ALIGNMENT);
		
		add(button);
		add(mainTextPane);
	}
	
	public static void main(String [] args){ 
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrameDemo2 ex = new JFrameDemo2();
				ex.setVisible(true);
			}

		});
		
	}
	
}
