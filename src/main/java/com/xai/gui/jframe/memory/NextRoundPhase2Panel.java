package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class NextRoundPhase2Panel extends JPanel {

	private JPanel colorDisplayPanel;
	private HeaderPanel headerPanel;
	
	public NextRoundPhase2Panel(ActionListener colorBtnActionListener, GameData gameData){
		super(new BorderLayout());
		this.setBackground(Color.BLACK);
		
		//header (includes - count down timer, round);
		headerPanel = new HeaderPanel(gameData.currentTimeLeft, gameData.getCurrentRound());
		this.add(headerPanel, BorderLayout.NORTH);
		
		//body or center panel - displays the color inputs
		colorDisplayPanel = new ColorDisplayPanel();
		this.add(colorDisplayPanel, BorderLayout.CENTER);
		
		//create the footer panel then hook up footer buttons to event
		FooterPanel	footerPanel = new FooterPanel();
		
		//hook up red btn event
		footerPanel.getRedBtn().addActionListener(colorBtnActionListener);
		//hook up green btn event
		footerPanel.getGreenBtn().addActionListener(colorBtnActionListener);
		//hook up blue btn event
		footerPanel.getBlueBtn().addActionListener(colorBtnActionListener);
		
		this.add(footerPanel, BorderLayout.SOUTH);
		
	}
	
	public void setTimerLabel(int value){
		headerPanel.setTimerLabel(value);
	}
	
	public JPanel getColorDisplayPanel(){
		return colorDisplayPanel;
	}
}
