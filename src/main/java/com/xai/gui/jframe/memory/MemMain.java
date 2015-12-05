package com.xai.gui.jframe.memory;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.UIManager;

public class MemMain {

	public static void main(String [] args){
		
		//because the setVisible has to be called last in order to see the gui
		//this helps render the gui after everything has been set
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				//set ui default font
				setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,12));
				
				MemFrame gui = new MemFrame();
				gui.setVisible(true);
			}

		});
		
		
		
		//bring the gui
		
		
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
