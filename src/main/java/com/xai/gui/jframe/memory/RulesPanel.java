package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class RulesPanel extends JPanel {

	public RulesPanel(ActionListener startBtnActionalListener){
		
		super(new BorderLayout());

		this.setBackground(Color.BLACK);
		
		//screen title
		JLabel screenTitle = new JLabel("<html><font size=+2 color=white>Rules</font></html>");
		screenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(screenTitle, BorderLayout.NORTH);
		
		//rules
		JTextArea ta = new JTextArea(2,10);
		ta.setLineWrap( true );
		ta.setWrapStyleWord(true);
		ta.setBorder(BorderFactory.createCompoundBorder(
				this.getBorder(),
				BorderFactory.createEmptyBorder(15,15,15,15)));
		
		String ruleText = ""
				+ "- Every round a pattern will be display for X seconds\n"
				+ "- After X seconds, pattern will disappear and round will begin\n"
				+ "- When round begin, player gets X seconds to recite the pattern\n"
				+ "- Recite the pattern correctly in order and from left to right\n"
				+ "- Use the 3 buttons at the bottom to make your choices\n"
				+ "- A wrong color will immediately be gameover\n"
				+ "- Try to get the highest round possible\n"
				+ "- At gameover scree, you can choose to input a name to save your score";
		ta.setText(ruleText);
		this.add(ta, BorderLayout.CENTER);
		
		//start
		BasicButton startBtn = new BasicButton("Start");
		startBtn.addActionListener(startBtnActionalListener);
		
		JPanel startPanel = new JPanel();
		startPanel.setBackground(Color.BLACK);
		startPanel.add(startBtn);
		this.add(startPanel, BorderLayout.SOUTH);
		
	}
}
