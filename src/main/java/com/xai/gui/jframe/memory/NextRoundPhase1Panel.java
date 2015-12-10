package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NextRoundPhase1Panel extends JPanel {
	
	public NextRoundPhase1Panel(GameData gameData){
		
		super(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		//NORTH section
		int currentRoundTimer = gameData.getCurrentRoundTotalTimeForPreview();
		JLabel info = new JLabel("You have " + currentRoundTimer + " sec for preview starting now");
		this.add(info, BorderLayout.NORTH);
		
		//body
		ColorDisplayPanel centerPanel = new ColorDisplayPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		
		//display the colors to memorize
		List<Integer> tempRoundColorIdPattern = gameData.getCurrentRoundColorIdPattern();
		for(int i=0; i<tempRoundColorIdPattern.size(); i++){
			centerPanel.add(new ColorGraphicIcon(tempRoundColorIdPattern.get(i)));
		}
		
	}
}
