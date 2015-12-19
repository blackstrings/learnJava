package com.xai.gui.jframe.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CFrame extends JFrame {
	private final int width = 225;
	private final int height = 143;
	CService service;
	
	public CFrame(){
		setTitle("C Test");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//to get frame to appear at lower bottom right
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - getWidth();
        int y = (int) rect.getMaxY() - getHeight();
        setLocation(x, y);
		//--end of frame at lower bottom right
        
		init();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width,height);
	}
	
	private void init(){
		//init
		service = new CService();
		
		//how many players
		service.addPlayers(2);
		
		//loadScreen1001();
		loadScreen1002();
		
	}
	
	//test screen
	private void loadScreen1001(){
		clear();
		
		DisplayPanel mainPnl = new DisplayPanel(service.getDeck());
		mainPnl.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(mainPnl);
		mainPnl.setBackground(Color.GRAY);
		
		CardPanel j2 = new CardPanel(new FlowLayout());
		j2.add(service.getDeck().getCard(0));
		j2.add(service.getDeck().getCard(1));
		mainPnl.add(j2);
		
		JButton nextScreenBtn = new JButton("t");
		nextScreenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadScreen1002();
			}
		});
		mainPnl.add(nextScreenBtn);
	}
	
	//deal screen
	private void loadScreen1002(){
		clear();
		JPanel mainPanel = new JPanel(new BorderLayout());
		add(mainPanel);
		
		JPanel playerPnl = new JPanel(new GridLayout(2,1,0,0));
		mainPanel.add(playerPnl, BorderLayout.WEST);
		JLabel p1Label = new JLabel("P1");
		p1Label.setBackground(Color.blue);
		p1Label.setForeground(Color.white);
		p1Label.setOpaque(true);
		playerPnl.add(p1Label);
		
		JLabel p1Labe2 = new JLabel("P2");
		p1Labe2.setBackground(Color.red);
		p1Labe2.setForeground(Color.white);
		p1Labe2.setOpaque(true);
		playerPnl.add(p1Labe2);
		
		//center
		JPanel cardDisplayPanel = new JPanel(new BorderLayout());
		mainPanel.add(cardDisplayPanel, BorderLayout.CENTER);
		
		//this comes before the header
		int numOfCards = 5;
		service.deal(PlayerId.ONE, numOfCards);
		service.deal(PlayerId.TWO, numOfCards);
		
		if(service.isPlayersHandsEmpty()){
			service.refreshDeck();
			
			//anonymous method which uses anonymous initialize at instantiation
			cardDisplayPanel.add(new JLabel("Reshuffling"){
				//initialize at start
				{
					setHorizontalAlignment(CENTER);
				}
			});
			
		}else{	//display the player's hand cards
			
			CardPanel p1HandPanel = new CardPanel(new GridLayout(1,numOfCards,0,0));
			cardDisplayPanel.add(p1HandPanel, BorderLayout.NORTH);
			CardPanel P2HandPanel = new CardPanel(new GridLayout(1,numOfCards,0,0));
			cardDisplayPanel.add(P2HandPanel, BorderLayout.CENTER);
		
			PlayerBO p1 = service.getPlayerRepo().getPlayer(PlayerId.ONE);
			PlayerBO p2 = service.getPlayerRepo().getPlayer(PlayerId.TWO);
			
			for(Card c : p1.getHand()){
				p1HandPanel.add(c);
			}
			for(Card c : p2.getHand()){
				P2HandPanel.add(c);
			}
			
			service.match(PlayerId.ONE, PlayerId.TWO, 100);
		}
		
		//header
		JPanel headerPnl = new JPanel();
		headerPnl.add(new JLabel("Deck Size: " + service.getDeck().getSize() + "/52"));
		mainPanel.add(headerPnl, BorderLayout.NORTH);
		
		
		JButton dBtn = new JButton("Deal");
		mainPanel.add(dBtn, BorderLayout.SOUTH);
		dBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadScreen1002();
			}
		});
	}
	
	//clears everything put into the frame
	public void clear(){
		Container frame = this.getContentPane();
		frame.removeAll();
		frame.revalidate();
		frame.repaint();
	}
	
	
}
