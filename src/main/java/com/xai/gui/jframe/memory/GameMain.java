package com.xai.gui.jframe.memory;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GameMain {
	
	public static void main(String [] args){
		
		//handles setting up any configuration
		//currently the only thing it does is change the default overall gui font type and size
		//the default font size is kind of lame, so we changed it
		runAppConfig();
		
		//finally start the game
		startApp();
		
	}
	
	private static void startApp(){
		
		//run the gui which carries the entire game contents and gui
		GameFrame gui = new GameFrame();
		gui.setVisible(true);
	
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
