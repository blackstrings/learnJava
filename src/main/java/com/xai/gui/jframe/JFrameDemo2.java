package com.xai.gui.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
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

	
	public JFrameDemo2(){
		initUI();
	}
	
	private static int width = 600;
	private static int height = 300;
	
	private void initUI(){
		//main window container
		setTitle("JFrame Example 2");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JTextPane mainTextPane = new JTextPane();
		mainTextPane.setText("This is some text");
		mainTextPane.setBounds(10, 200, 200, 200);
		
		loadMenu(this, BorderLayout.NORTH);
		
		add(mainTextPane, BorderLayout.SOUTH);
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
	
	private void loadMenu(JFrame frame, String layout){
		
		//quit
		JButton btn_exit = new CustomJButton("Quit", 0, 0, 100,30);
		btn_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//mainTextPane.setText("This is new text you see");
				System.exit(0);
			}
		});
		
		//test
		JButton btn_test = new CustomJButton("Test", 0, 0, 200, 30);
		btn_test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test button");
			}
		});
		
		//when adding jpanel, it is recomended to give it a layout manager
		//don't use default constructor and set layout after creation
		//pass in layout manager instead at creation
		JPanel panelMenu = new JPanel(new GridBagLayout());
		panelMenu.add(btn_exit);
		panelMenu.add(btn_test);
		
		//add button to frame
		frame.add(panelMenu, layout);
	}
	
}
