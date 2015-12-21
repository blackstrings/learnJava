package com.xai.gui.jframe.rp;

import javax.swing.SwingUtilities;

import com.xai.gui.jframe.rp.gui.RFrame;

public class RPDemo {

	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				RFrame frame = new RFrame();
				frame.setVisible(true);
			}
		});
		
	}
}
