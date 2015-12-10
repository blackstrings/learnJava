package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

//this class is the gui, it displays the buttons the the selected colors to press and the colors pressed
public class GameFrame extends JFrame {

	//use enum to help us keep track what screen state we are in
	//enum is really similar to had we use int
	//enum is word base rather than number base
	//the fact that word is easier to read for human than numbers, enum is a good choice
	//with int numbers, you have to translate the number to its true meaning
	//with enum, we can just use words, which again is easier to read
	//ex had we use int:
	//int ScreenState;	//where 0 = welcome, 1 = Rules, 2 = Phase1, etc ...
	//you can see using numbers to keep track of the screen status would be more confusing than
	//using enums
	//--------------------------------------------------------------
	//create our custom enum - this line is like creating a regular class - except it is an enum
	enum ScreenState {Welcome, Rules, Phase1, Phase2, Gameover};
	//prepare the enum
	private ScreenState screenState = ScreenState.Welcome;
	
	//where all the game data is stored
	GameData gameData = null;
	
	//to help with methods that need to happen after X seconds
	Timer timer = null;
	
	public GameFrame(){
		init();					//pretty much does the basic width and height initialization
		loadWelcomeScreen();	//load the welcome screen
	}
	
	//do width and height initialization stuff for the main frame
	public void init(){
		setTitle("Memory");
		Dimension mainSize = new Dimension(500,300);
		setSize(mainSize);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
	}
	
	//every time any of the color button(s) are press at runtime, call this method
	//checks what button is pressed, and updates the entire game data 
	//and checks if is game over or next round etc.
	public void onClickUpdateGame(ColorButton selectedColorButton){
		
		//the long method name speaks for itself
		//note: we made gameData global and was initalized/created at the loadWelcomeScreen()
		gameData.validateSelectedColorAgainstCurrentPattern(selectedColorButton.getId());
		
		//update the gui and render the color that was pressed
		//regardless if the correct or wrong color was preseed
		this.drawSelectedColorToDisplayScreen( selectedColorButton.getColor());
		
		//game logic checks and validation
		if(gameData.isSelectedColorCorrect && gameData.validateIsRoundComplete()){
			//this was kind of annoying so we are turning it off
			//JOptionPane.showMessageDialog(null, "Congrats! Get Ready For Next Round");
			gameData.nextRound();
			clearTimer();
			this.loadNextRoundPhase1Screen();
			
		}else if(!gameData.isSelectedColorCorrect){
			//this was kind of annoying so we are turning it off
			//JOptionPane.showMessageDialog(null, "Incorrect Color! GameOver");
			
			//force game over
			gameData.gameOver();	//update the gamedata that it is gameover
			clearTimer();
			loadGameoverScreen();	//load new screen
			
		}else{
			//allow user to keep going since there is more colors to select and
			//so far colors are correctly pressed
		}
		
	}
	
	// welcome screen
	//----------------------
	// WelcomeGameTitle
	//----------------------
	// playBtn
	//----------------------
	public void loadWelcomeScreen(){
		clearFrame();	//clear the entire frame and start a fresh empty frame
		screenState = ScreenState.Welcome;	//set and update the screen state
		
		//start with fresh data
		gameData = new GameData();	
		
		//prepare playtBtn action listener for the welcome panel
		ActionListener playBtnAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRulesScreen();
			}
		};
		
		//create welcome screen
		//this allows the welcome panel's play button to call the loadRulesScreen()
		//that exist in this class
		WelcomePanel ws = new WelcomePanel(playBtnAL);

		//add welcome panel to frame
		this.add(ws);
	}
	
	//rules screen
	//-------------
	// rulesTitle
	//-------------
	// rule 1
	// rule 2
	// rule ...
	// rule 9
	//-------------
	// startButton
	//-------------
	//
	public void loadRulesScreen(){
		clearFrame();
		screenState = ScreenState.Rules;
		
		//prepare startBtna action listener for rules panel
		ActionListener startBtnAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNextRoundPhase1Screen();
			}
		};
		
		//create rules panel
		RulesPanel rulesPanel = new RulesPanel(startBtnAL);
		this.add(rulesPanel);
	}
	
	//phase1 screen
	//-----------------------------
	// you have X secs for preview
	//-----------------------------
	// (red)(red)(green)(blue)	- displays pattern to memorize
	//-----------------------------
	//
	//this pre round screen flashes the pattern for player to memorize
	//based on a timer it will disappear and the round will begin
	public void loadNextRoundPhase1Screen(){
		clearFrame();
		screenState = ScreenState.Phase1;
		
		//TODO make sure this is commented off in final
		//System.out.println("Starting pre round");
		
		//create next round phase 1 panel
		NextRoundPhase1Panel phase1Panel = new NextRoundPhase1Panel(gameData);
		this.add(phase1Panel);
		
		//The end of the timer will take us to the next screen
		//make sure to multiple game seconds by 1000 to get milliseconds as timer functions in milliseconds
		//1 sec = 1000, 2 sec = 2000, ... 10 sec = 10000 etc
		int timeGivenToPlayer = gameData.getCurrentRoundTotalTimeForPreview()*1000;
		timer = new Timer(timeGivenToPlayer, new ActionListener() {
			//trigger this method when the time reaches 0
			public void actionPerformed(ActionEvent e) {
				timer.stop();	//we have to stop the time or it will keep triggering this method
				timer = null;	//we don't need this timer anymore after this method triggers
				loadNextRoundPhase2Screen();
			}
		});
		
		timer.start();
	}
	
	//this is here for one reason
	//to allow use to access the panel and draw selected colors to
	//its color display panel inside this phase2Panel
	private NextRoundPhase2Panel phase2Panel;
	
	// Phase2 screen
	//-------------------------------------
	// Time left                    Round 0
	//-------------------------------------
	// (red)(blue)(blue) - colors being pressed
	//
	//
	//-------------------------------------
	// [redBtn] [greenBtn] [blueBtn]
	//-------------------------------------
	//
	//this is the actual round beginning
	public void loadNextRoundPhase2Screen(){
		clearFrame();
		screenState = ScreenState.Phase2;	//set and update the screen state
		clearTimer();	//in case there is a timer still running, clear it
		
		//TODO make sure this is off in final
		//System.out.println("round starting");
		
		ActionListener colorBtnAL = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//get the object that got clicked on - e.getSource()
				//and cast it to the correct class - (ColorButton)
				//then pass it to the updateGame as argument
				onClickUpdateGame(((ColorButton)e.getSource()));
			}
		};

		//though player gets a shorter time to preview the pattern
		//for selected player gets 2x more time to select answer, so we multiple by 2
		//it is important this comes first before you create the nextRoundPhase2Panel
		gameData.currentTimeLeft = gameData.getCurrentRoundTotalTimeForPreview();

		//create phase 2 panel
		phase2Panel = new NextRoundPhase2Panel(colorBtnAL, gameData);
		this.add(phase2Panel);
		
		//1000 = 1 second in real time
		timer = new Timer(1000, new ActionListener() {
			//trigger this method every second
			public void actionPerformed(ActionEvent e) {
				
				if(gameData.currentTimeLeft > 0){
					gameData.currentTimeLeft--;
					phase2Panel.setTimerLabel(gameData.currentTimeLeft);
				}else{
					timer.stop();	//we have to stop the time or it will keep triggering this method
					timer = null;	//we don't need this timer anymore after this method triggers
					//2 codse above is same as calling clearTimer();
					System.out.println("times up");
					loadGameoverScreen();
				}
			}
		});
		
		//start the timer so the above event can trigger which loads the game over screen
		timer.start();
	}
	
	// gameover screen
	//------------------------------------
	//            gameOvertitle
	//------------------------------------
	// high scores?
	// tom ... 5
	// Kim ... 29
	//
	//------------------------------------
	//                         [replayBtn]
	//------------------------------------
	public void loadGameoverScreen(){
		clearFrame();
		screenState = ScreenState.Gameover;	//set and update the screen state
		
		//TODO turn off in final
		System.out.println("Gameover");
		
		//prepare the replayBtn action listener for gameover panel
		ActionListener replayBtnAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadWelcomeScreen();
			}
		};
		
		//crate game over panel
		GameOverPanel gameOverPanel = new GameOverPanel(replayBtnAL, gameData);
		this.add(gameOverPanel);
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
	
	public void drawSelectedColorToDisplayScreen(Color color){
		//the ColorGraphicIcon is like an image
		//when we add to the panel, the icon will draw itself
		//since phase2Panel uses a flowLayout
		//it works perfectly as the image will auto
		//align itself into the panel into a grid like layout
		//as you keep adding more colorGraphicIcon
		
		//the color button that was pressed, passes it's color into this method
		//this new icon will take the color of that pressed button
		phase2Panel.getColorDisplayPanel().add(new ColorGraphicIcon(color));
		
		//tell the frame to redraw itself
		//any child that has changes will redraw itself
		//these thow method should be called
		revalidate();
		repaint();
	}
	
	private void clearTimer(){
		if(timer != null){
			timer.stop();
			timer = null;
		}
	}
	
	
}
