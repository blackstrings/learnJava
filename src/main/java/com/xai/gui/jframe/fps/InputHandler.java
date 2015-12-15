package com.xai.gui.jframe.fps;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	private int keycode;
	
	public InputHandler(Component mainGame){
		//add this keylistener to the mainGame on creation
		mainGame.addKeyListener(this);
	}
	
	
	public boolean isKeyDown(int key){
	
		if(key == keycode){
			return true;
		}
		return false;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keycode = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keycode = 0;
		
	}
	
	

}
