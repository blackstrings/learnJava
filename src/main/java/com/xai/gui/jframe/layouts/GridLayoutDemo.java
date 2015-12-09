package com.xai.gui.jframe.layouts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * gridlayout and borders
 *
 */
public class GridLayoutDemo extends JFrame {

	private Dimension size;
	
	public GridLayoutDemo(){
		init();
		loadScreen1();
	}
	
	public static void main(String [] args){
		//use this method to invoke jframe so setvisible is called last
		EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	GridLayoutDemo demo = new GridLayoutDemo();
            	demo.setVisible(true);
            }
        });
	}
	
	public void init(){
		size = new Dimension(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("test");
		setSize(size);
	}
	
	private void loadScreen1(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		//creates border
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		
		//grid layout (rows, col, hgap, vgap)
		//0 = as many row/col as needed, but only one can be zeroed
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		this.add(panel);

		//auto places items into grid accordingly to order
		panel.add(createLabel("1"));
		panel.add(createLabel("1"));
		panel.add(new JLabel("3"));
		panel.add(new JLabel("4"));
		panel.add(new JLabel("5"));
		panel.add(new JLabel("6"));
		panel.add(new JLabel("7"));
		panel.add(new JLabel("8"));
		panel.add(new JLabel("9"));
		panel.add(new JLabel("10"));
		panel.add(new JLabel("11"));
		panel.add(new JLabel("12"));
		panel.add(new JLabel("13"));
	}
	
	private JLabel createLabel(String text){
		JLabel lb = new JLabel(text);
		lb.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		return lb;
	}
	
	
}
