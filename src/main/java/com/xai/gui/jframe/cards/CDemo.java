package com.xai.gui.jframe.cards;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CDemo {

	
	public static void main(String[] args){
		
		runAppConfig();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CFrame f = new CFrame();
				f.setVisible(true);
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
