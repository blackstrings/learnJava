package com.xai.gui.jframe.cards;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {

	Deck deck;
	public DisplayPanel(Deck deck){
		this.deck = deck;
	}
	private int maxc = 4;
	
	/**
	 * when you play with a jpanel's paint component, you are drawing it's background
	 * any components added to the jpanel will be render ontop of the background stuff
	 */
	public void paintComponent(Graphics g){
		//this basicaly says paint all the bottom layers or its parent
		//up to this point
		super.paintComponent(g);
		
		//then continue and paint over with the below 

		//rarely should you have to custom paint other JComponents inside the JPanel
		//avoid this method if you need the jcomponents to be clickable
		//only use this method if you only care about repainting components
		int hPad = (int)deck.getCard(0).getPreferredSize().getWidth() + 2;
		int vPad = (int)deck.getCard(0).getPreferredSize().getHeight() + 2;
		int counter = 0;
		int mrow = 3;
		int mcol = 3;
		for(int row=0; row<mrow; row++){
			for(int col=0; col<mcol; col++){
				if(counter < maxc){
					//tell other jcomponents to paint itself
					deck.getCard(counter).paintComponent(g,col*hPad,row*vPad);
					counter++;
				}else{
					break;
				}
				
			}
		}
	}
}
