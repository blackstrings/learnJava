package com.xai.gui.jframe.cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

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
		
		//if we want to print text
		/*
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.drawString(suit.name(), 1, 10);
		g.drawString(rank.name().toLowerCase(), 1, 25);
		*/
		
		//g.setColor(Color.white);
		//g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawString(rank.symbol(), 25, 15);
		
		String imgPath = "";
		
		switch (suit) {
		case Clubs:
			imgPath = "club.png";
			break;
		case Hearts:
			imgPath = "heart.png";
			break;
		case Diamonds:
			imgPath = "diamond.png";
			break;
		case Spades:
			imgPath = "spade.png";
			break;
		default:
			imgPath = "spade.png";
			break;
		}
		
		//load and draw image
		ImageIcon img = new ImageIcon("res/images/card/"+imgPath);
		//draw the image, you can draw it as many times as you want
		g.drawImage(img.getImage(),2,2,null);
	}
	
	//custom advance drawing
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
