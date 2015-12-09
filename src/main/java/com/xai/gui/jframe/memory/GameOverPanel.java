package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GameOverPanel extends JPanel {

	public GameOverPanel(ActionListener replayBtnActionListener, GameData gameData){
		super(new BorderLayout());
		setBackground(Color.BLACK);
		
		JLabel gameOverLabel = new JLabel("<html><font size=+2 color=white>GameOver</font></html>");
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(gameOverLabel, BorderLayout.NORTH);
		
		
		//hs = high score
		//-------------------------------------------------------
		JPanel hsPanel = new JPanel(new BorderLayout());
		this.add(hsPanel, BorderLayout.CENTER);
		
		JLabel playerScore = new JLabel("Rounds Completed: "+gameData.getCurrentRound() + " - High Scores");
		playerScore.setHorizontalAlignment(SwingConstants.CENTER);
		playerScore.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		hsPanel.add(playerScore, BorderLayout.NORTH);

		//high score text area
		JTextArea ta = new JTextArea(3,5);
		//test dummy scores
		String scoresText = "Tom ... 22\n"
				+ "John ... 20\n"
				+ "Kim ... 2";
		ta.setText(scoresText);
		hsPanel.add(ta, BorderLayout.CENTER);
		//---------------------------------------------------------
		
		//Replay button
		JButton replayBtn = new JButton("Replay");
		//hook up the button to call a method
		//in this case we go back to welcome screen
		replayBtn.addActionListener(replayBtnActionListener);
		
		//we put the replay btn inside another panel
		//so the btn will not stretch across the entire frame
		//basically it helps the button stay a normal button and not a stretched button
		JPanel replayPanel = new JPanel(new FlowLayout(2));	//2 - shifts the button to the far right
		replayPanel.setBackground(Color.BLACK);
		replayPanel.add(replayBtn);
		this.add(replayPanel, BorderLayout.SOUTH);
		
		
	}
}
