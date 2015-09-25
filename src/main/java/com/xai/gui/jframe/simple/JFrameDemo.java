package com.xai.gui.jframe.simple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameDemo {

	public static void main(String[] args) {

		MyWindow window = new MyWindow("My New Window");
		
		//---NORTH panel
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.BLUE);
		//label for text
		JLabel label = new JLabel("My Label");
		label.setPreferredSize(new Dimension(100,50));
		label.setForeground(Color.white);
		panelN.add(label);
		
		//------ EAST panel
		//label will go into panel
		JPanel panelE = new JPanel();
		panelE.setBackground(Color.RED);
		//we do not need to set size if the parent frame is using borderLayout
		//panelE.setSize(100, 100);
		
		//------- WEST panel
		JPanel panelW = new JPanel();
		panelW.setBackground(Color.PINK);
		
		//-------- SOUTH panel
		JPanel panelS = new JPanel();
		panelS.setBackground(Color.GREEN);
		CustomComp c = new CustomComp(150,80);	//this jcomponent size will force panelS to enlarge to fit this component
		c.setSize(100, 100);
		panelS.add(c);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(panelE, BorderLayout.EAST);
		mainPanel.add(panelN, BorderLayout.NORTH);
		mainPanel.add(panelW, BorderLayout.WEST);
		mainPanel.add(panelS, BorderLayout.SOUTH);
		
		//panel will go into JFrame
		window.add(mainPanel);
		
		//if you want all cells to pack together use this
		//window.pack();
		
	}

}
