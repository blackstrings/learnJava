package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//this class is the gui, it displays the buttons the the selected colors to press and the colors pressed
public class GameFrame extends JFrame {

	//helps use keep track what screen state we are in
	enum ScreenState {Welcome, Start, Gameover};
	private ScreenState screenState;
	
	GameStatus gameStatus;
	
	public GameFrame(GameStatus gameStatus){
		this.gameStatus = gameStatus;
		init();
		loadWelcomeScreen();
	}
	
	public void init(){
		setTitle("Memory");
		Dimension mainSize = new Dimension(300,300);
		setSize(mainSize);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
	}
	
	//this is part of the core checking each time a color button is pressed
	//it updates the entire game data and checks if is game over or next round etc.
	public void updateGame(ColorButton selectedColorButton){
		gameStatus.validateSelectedColorAgainstCurrentPattern(selectedColorButton.getId());
		
		//update the gui regardless if correct or wrong color is selected
		this.updateInputDisplayScreen( selectedColorButton.getColor());
		
		//run logics
		if(gameStatus.isSelectedColorCorrect && gameStatus.validateIsRoundComplete()){
			gameStatus.nextRound();
			this.displayNextRoundScreen();
			System.out.println("new round");
		}else if(!gameStatus.isSelectedColorCorrect){
			gameStatus.gameOver();	//force go
			gameStatus = new GameStatus();
			loadWelcomeScreen();
		}else{
			//allow user to keep going since there is more colors to select and
			//so far colors are correctly pressed
		}
		
	}
	
	public void loadWelcomeScreen(){
		clearFrame();
		screenState = ScreenState.Welcome;	//set and update the screen state
		
		JPanel layoutPanel = new JPanel(new BorderLayout());
		layoutPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		layoutPanel.setBackground(Color.GRAY);
		this.add(layoutPanel);
		
		//title
		String titleText = "<html><font size=+2 color=gray>The</font> <font color=gray>Memory</font></html>";
		TitleLabel title = new TitleLabel(titleText);
		layoutPanel.add(title, BorderLayout.NORTH);
		
		//copyright
		String text2 = "<html><font color=gray> copyright&copy;2015 </font></html>";
		CopyrightLabel copyright = new CopyrightLabel(text2);
		layoutPanel.add(copyright, BorderLayout.SOUTH);
		
		//start button
		StartButton startBtn = new StartButton();
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayNextRoundScreen();
			}
		});
		
		JPanel flowLayout = new JPanel(new FlowLayout());
		flowLayout.setBackground(Color.GRAY);
		flowLayout.add(startBtn);
		layoutPanel.add(flowLayout, BorderLayout.CENTER);
		
		
	}
	
	private HeaderPanel headerPanel;
	private ColorDisplayPanel bodyPanel;
	
	public void displayNextRoundScreen(){
		clearFrame();
		screenState = ScreenState.Start;	//set and update the screen state
		
		//container
		JPanel layoutPanel = new JPanel(new BorderLayout());
		layoutPanel.setBackground(Color.BLACK);
		this.add(layoutPanel);
		
		//header (count down timer, round);
		headerPanel = new HeaderPanel(gameStatus.getRoundTimer(), gameStatus.getCurrentRound());
		layoutPanel.add(headerPanel, BorderLayout.NORTH);
		
		//body
		bodyPanel = new ColorDisplayPanel();
		
		
		layoutPanel.add(bodyPanel, BorderLayout.CENTER);
		
		
		//create the footer panel then hook up footer buttons to event
		FooterPanel footerPanel = new FooterPanel();
		ActionListener colorBtnAL = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//get the object that got clicked on - e.getSource()
				//and cast it to the correct class - (ColorButton)
				//then pass it to the updateGame as argument
				updateGame(((ColorButton)e.getSource()));
			}
		};
		//red btn event hook up
		footerPanel.getRedBtn().addActionListener(colorBtnAL);
		//green btn event hook up
		footerPanel.getGreenBtn().addActionListener(colorBtnAL);
		//red btn event hook up
		footerPanel.getBlueBtn().addActionListener(colorBtnAL);
		
		layoutPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	
	
	public void loadGameoverScreen(){
		clearFrame();
		screenState = ScreenState.Gameover;	//set and update the screen state
		
		
	}
	
	//call this each time you want to load a new screen
	//it will wipe out any JPanels or components that has been added to the frame
	public void clearFrame(){
		Container frame = this.getContentPane();
		frame.removeAll();
		frame.revalidate();
		frame.repaint();
	}
	
	//-------------------------------------
	// Methods to update gui elements such as text, timer text, displays etc
	//------------------------------------
	
	public void setTimerLabel(int value){
		//only allow if the game state mode is in start mode
		if(screenState.equals(ScreenState.Start)){
			headerPanel.setTimerLabel(value);
		}
	}
	
	public void updateInputDisplayScreen(Color color){
		//Integer[] testArr = new Integer[]{1,2,1,0,0,0,2,1};
		//List<Integer> inputsSoFar = Arrays.asList(testArr);
		
		//bodyPanel.updateScreen(inputsSoFar);
		bodyPanel.add(new ColorGraphicIcon(color));
		//bodyPanel.repaint();
		
		//tell the frame to redraw itself
		//any child that has changes will redraw itself
		revalidate();
		repaint();
	}
	
	
}
