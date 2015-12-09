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
	//you can see using numbers to keep track of the screen stat would be more confusing than
	//using enums
	//--------------------------------------------------------------
	//create our custom enum - this line is like creating a regular class - except it is an enum
	enum ScreenState {Welcome, Rules, Phase1, Phase2, Gameover};
	//prepare the enum
	private ScreenState screenState;
	
	//where all the game data is stored
	GameData gameData;
	
	//to help with methods that need to happen after X seconds
	Timer timer;
	
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
		this.drawInputToDisplayScreen( selectedColorButton.getColor());
		
		//game logic checks and validation
		if(gameData.isSelectedColorCorrect && gameData.validateIsRoundComplete()){
			//this was kind of annoying so we are turning it off
			//JOptionPane.showMessageDialog(null, "Congrats! Get Ready For Next Round");
			gameData.nextRound();
			this.loadNextRoundPhase1Screen();
			
		}else if(!gameData.isSelectedColorCorrect){
			//this was kind of annoying so we are turning it off
			//JOptionPane.showMessageDialog(null, "Incorrect Color! GameOver");
			
			//force game over
			gameData.gameOver();	//update the gamedata that it is gameover
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
		
		JPanel welcomPanel = new JPanel(new BorderLayout());
		welcomPanel.setBackground(Color.BLACK);
		this.add(welcomPanel);
		
		//title
		String titleText = "<html><font size=+2 color=white>The</font> <font color=red>Memory</font></html>";
		TitleLabel title = new TitleLabel(titleText);
		welcomPanel.add(title, BorderLayout.NORTH);
		
		//start button
		BasicButton playBtn = new BasicButton("Play");
		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRulesScreen();
			}
		});
		
		//we don't want start button to stretch across the entire screen
		//so we create a seperate panel for start button
		//if startBtn is inside its own panel, it won't stretch
		JPanel playBtnPanel = new JPanel(new FlowLayout()){
			public void paintComponent(Graphics g){
				ImageIcon img = new ImageIcon("src/main/java/com/xai/gui/jframe/memory/bg1.png");
				g.drawImage(img.getImage(), 50, 20, null);
			}
			public Dimension getPreferredSize(){
				return new Dimension(50,50);
			}
		};
		
		playBtnPanel.add(playBtn);
		playBtnPanel.setVisible(true);
		welcomPanel.add(playBtnPanel, BorderLayout.CENTER);
		
		//copyright text for bottom of screen
		String text2 = "<html><font color=gray> copyright&copy;2015 </font></html>";
		CopyrightLabel copyright = new CopyrightLabel(text2);
		welcomPanel.add(copyright, BorderLayout.SOUTH);
	}
	
	private HeaderPanel headerPanel;
	private ColorDisplayPanel centerPanel;
	private FooterPanel footerPanel;
	
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
		
		JPanel rulesPanel = new JPanel(new BorderLayout());
		rulesPanel.setBackground(Color.BLACK);
		this.add(rulesPanel);
		
		//screen title
		JLabel screenTitle = new JLabel("<html><font size=+2 color=white>Rules</font></html>");
		screenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rulesPanel.add(screenTitle, BorderLayout.NORTH);
		
		//rules
		JTextArea ta = new JTextArea(2,10);
		ta.setLineWrap( true );
		ta.setWrapStyleWord(true);
		ta.setBorder(BorderFactory.createCompoundBorder(
				rulesPanel.getBorder(),
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
		rulesPanel.add(ta, BorderLayout.CENTER);
		
		//start
		BasicButton startBtn = new BasicButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNextRoundPhase1Screen();
			}
		});
		JPanel startPanel = new JPanel();
		startPanel.setBackground(Color.BLACK);
		startPanel.add(startBtn);
		rulesPanel.add(startPanel, BorderLayout.SOUTH);
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
		
		JPanel prPanel = new JPanel(new BorderLayout());
		prPanel.setBackground(Color.WHITE);
		this.add(prPanel);
		
		//NORTH section
		int currentRoundTimer = gameData.getCurrentRoundTimer();
		JLabel info = new JLabel("You have " + currentRoundTimer + " sec for preview starting now");
		prPanel.add(info, BorderLayout.NORTH);
		
		//body
		centerPanel = new ColorDisplayPanel();
		prPanel.add(centerPanel, BorderLayout.CENTER);
		
		//display the colors to memorize
		List<Integer> tempRoundColorIdPattern = gameData.getCurrentRoundColorIdPattern();
		for(int i=0; i<tempRoundColorIdPattern.size(); i++){
			centerPanel.add(new ColorGraphicIcon(tempRoundColorIdPattern.get(i)));
		}
		
		//The timer
		//make sure to multiple game seconds by 1000 to get milliseconds as timer functions in milliseconds
		//1 sec = 1000, 2 sec = 2000, ... 10 sec = 10000 etc
		timer = new Timer(gameData.getCurrentRoundTimer()*1000, new ActionListener() {
			//trigger this method when the time reaches 0
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				timer = null;	//we don't need this timer anymore after this method triggers
				loadNextRoundPhase2Screen();
			}
		});
		
		timer.start();
	}
	
	// Phase2 screen
	//-------------------------------------
	// Time left                    Round 0
	//-------------------------------------
	// (red)(blue)(blue) - colors being pressed
	//
	//
	//-------------------------------------
	// (redBtn) (greenBtn) (blueBtn)
	//-------------------------------------
	//
	//this is the actual round beginning
	public void loadNextRoundPhase2Screen(){
		clearFrame();
		screenState = ScreenState.Phase2;	//set and update the screen state
		
		//TODO make sure this is off in final
		//System.out.println("round starting");
		
		//container
		JPanel beginRoundPanel = new JPanel(new BorderLayout());
		beginRoundPanel.setBackground(Color.BLACK);
		this.add(beginRoundPanel);
		
		//header (count down timer, round);
		headerPanel = new HeaderPanel(gameData.getCurrentRoundTimer(), gameData.getCurrentRound());
		beginRoundPanel.add(headerPanel, BorderLayout.NORTH);
		
		//body or center panel - displays the color inputs
		centerPanel = new ColorDisplayPanel();
		beginRoundPanel.add(centerPanel, BorderLayout.CENTER);
		
		//create the footer panel then hook up footer buttons to event
		footerPanel = new FooterPanel();
		//AL = short for actionListener
		ActionListener colorBtnAL = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//get the object that got clicked on - e.getSource()
				//and cast it to the correct class - (ColorButton)
				//then pass it to the updateGame as argument
				onClickUpdateGame(((ColorButton)e.getSource()));
			}
		};
		//hook up red btn event
		footerPanel.getRedBtn().addActionListener(colorBtnAL);
		//hook up green btn event
		footerPanel.getGreenBtn().addActionListener(colorBtnAL);
		//hook up blue btn event
		footerPanel.getBlueBtn().addActionListener(colorBtnAL);
		
		beginRoundPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	// gameover screen
	//------------------------------------
	//            gameOvertitle
	//------------------------------------
	// high scores?
	//
	//
	//
	//------------------------------------
	//                           replayBtn
	//------------------------------------
	public void loadGameoverScreen(){
		clearFrame();
		screenState = ScreenState.Gameover;	//set and update the screen state
		
		//game over panel = goPanel
		JPanel goPanel = new JPanel(new BorderLayout());
		goPanel.setBackground(Color.BLACK);
		this.add(goPanel);
		
		JLabel goLabel = new JLabel("<html><font size=+2 color=white>GameOver</font></html>");
		goLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goPanel.add(goLabel, BorderLayout.NORTH);
		
		//high score
		JPanel hsPanel = new JPanel(new BorderLayout());
		goPanel.add(hsPanel, BorderLayout.CENTER);
		JLabel hsScoreLabel = new JLabel("Highest Round Achieved");
		hsScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hsPanel.add(hsScoreLabel, BorderLayout.NORTH);
		//high score text area
		JTextArea ta = new JTextArea(3,5);
		//test dummy scores
		String scoresText = "Tom ... 22"
				+ "John ... 20\n"
				+ "Kim ... 2";
		ta.setText(scoresText);
		hsPanel.add(ta, BorderLayout.CENTER);
		
		//Replay button
		JButton replayBtn = new JButton("Replay");
		//hook up the button to call a method
		//in this case we go back to welcome screen
		replayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadWelcomeScreen();
			}
		});
		
		//we put the replay btn inside another panel
		//so the btn will not stretch across the entire frame
		//basically it helps the button stay a normal button and not a stretched button
		JPanel replayPanel = new JPanel(new FlowLayout(2));	//2 - shifts the button to the far right
		replayPanel.setBackground(Color.BLACK);
		replayPanel.add(replayBtn);
		goPanel.add(replayPanel, BorderLayout.SOUTH);
		
		
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
		//if(screenState.equals(ScreenState.Phase2)){
			headerPanel.setTimerLabel(value);
		//}
	}
	
	public void drawInputToDisplayScreen(Color color){
		//the ColorGraphicIcon is like an image
		//when we add to the panel, the icon will draw itself
		//since centerPanel uses a flowLayout
		//it works perfectly as the image will auto
		//align itself into the panel into a grid like layout
		//as you keep adding more colorGraphicIcon
		centerPanel.add(new ColorGraphicIcon(color));
		
		//tell the frame to redraw itself
		//any child that has changes will redraw itself
		//these thow method should be called
		revalidate();
		repaint();
	}
	
	
}
