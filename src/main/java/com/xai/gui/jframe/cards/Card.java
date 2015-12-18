package com.xai.gui.jframe.cards;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Card extends JComponent {
	private Suit suit;
	private Rank rank;
	private int width = 50;
	private int height = 30;
	
	public Card(Suit s, Rank r){
		suit = s;
		rank = r;
		setBorder(BorderFactory.createLineBorder(Color.gray));
	
		addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				if(getParent() instanceof CardPanel){
					((CardPanel)getParent()).removeComponentAndUpdate((Card)e.getSource());
				}else{
					System.err.println("Make sure card is added to a CardPanel for proper removing");
				}
			}
		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.drawString(suit.name(), 1, 10);
		g.drawString(rank.name().toLowerCase(), 1, 25);
	}
	
	//custom
	public void paintComponent(Graphics g, int x, int y){
		super.paintComponent(g);
		//g.setFont(new Font("Courier",Font.PLAIN, 8));
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawString(suit.name(), x+1, y+10);
		g.drawString(rank.name().toLowerCase(), x+1, y+25);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width,height);
	}
	
	public String toString(){
		return suit.name() + ":" + rank.name();
	}
	
	public Rank getRank(){
		return rank;
	}
	
	public Suit getSuit(){
		return suit;
	}
}
