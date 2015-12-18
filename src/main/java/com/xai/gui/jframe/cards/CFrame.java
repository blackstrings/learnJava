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
import javax.swing.JPanel;

public class CFrame extends JFrame {
	private final int width = 220;
	private final int height = 125;
	private Deck deck = null;
	public CFrame(){
		setTitle("C Test");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		deck = new Deck();
		
		//loadScreen1001();
		loadScreen1002();
		
	}
	
	//test screen
	private void loadScreen1001(){
		clear();
		
		DisplayPanel mainPnl = new DisplayPanel(deck);
		mainPnl.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(mainPnl);
		mainPnl.setBackground(Color.GRAY);
		
		CardPanel j2 = new CardPanel(new FlowLayout());
		j2.add(deck.getCard(0));
		j2.add(deck.getCard(1));
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
		JPanel p = new JPanel(new BorderLayout());
		
		CardPanel header = new CardPanel(new GridLayout(1,4,0,0));
		p.add(header, BorderLayout.NORTH);
		CardPanel center = new CardPanel(new GridLayout(1,4,0,0));
		p.add(center, BorderLayout.CENTER);
		
		int maxDeal = 2;
		List<Card> h1 = deck.deal(maxDeal);
		List<Card> h2 = deck.deal(maxDeal);
		
		if(h1.isEmpty() || h2.isEmpty()){
			deck.refresh();
		}
		
		for(Card c : h1){
			header.add(c);
		}
		for(Card c : h2){
			center.add(c);
		}
		
		
		add(p);
		
		JButton dBtn = new JButton("Deal - "+deck.getSize() + " cards left " + Rule.match(h1, h2));
		p.add(dBtn, BorderLayout.SOUTH);
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
