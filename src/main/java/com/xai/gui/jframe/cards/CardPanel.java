package com.xai.gui.jframe.cards;

import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Design specifically to allow us to remove a card on click
 * if card components are added to this panel
 *
 */
public class CardPanel extends JPanel {

	public CardPanel(LayoutManager layout){
		super(layout);
	}
	
	public void removeComponentAndUpdate(Card card){
		this.remove(card);
		//get the jframe root, then the container
		Container frame = ((JFrame) SwingUtilities.getWindowAncestor(this)).getContentPane();
		frame.revalidate();
		frame.repaint();
		
	}
}
