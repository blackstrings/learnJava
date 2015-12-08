package com.xai.gui.jframe.memory;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GameMain {
	
	public static void main(String [] args){
		
		runAppConfig();
		startApp();
		
	}
	
	private static void startApp(){
		
		//MemFrame gui = new MemFrame(game);
		//gui.setVisible(true);
		
		//because the setVisible has to be called last in order to see the gui
		//this helps render the gui after everything has been set
		
		/*
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				MemFrame gui = new MemFrame();
				gui.setVisible(true);
			
			}

		});
		*/
		
		//use swing to create a new thread
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	GameFrame gui = new GameFrame();
				gui.setVisible(true);
            }
        });
		
		
		
	}
	
	//do any configuration we need
	private static void runAppConfig(){
		//set ui default font type and font size
		//otherwise you will be using the ugly default font type and size
		setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,12));
	}
	
	/**
	 * sets the default font for the entire app
	 * @param
	 */
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value != null
					&& value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}
}
