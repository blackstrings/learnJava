package com.xai.gui.jframe;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JFrameDemo extends JFrame {

	public JFrameDemo() {
		initUI();
	}

	private void initUI() {

		//main window container
		setTitle("Simple example");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createButtons();
		
	}
	
	private void createButtons(){
		createLayout( new QuitButton("Quit") );
	}
	
	private void createLayout(JComponent...arg){
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);
		
		gl.setAutoCreateContainerGaps(true);
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]));
		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
		
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrameDemo ex = new JFrameDemo();
				ex.setVisible(true);
			}

		});

	}

}
