package com.xai.gui.jframe.startpack;

import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
	
	/**
	 * 0 = center, 1 = Top Left, 2 = Bottom Right, 
	 * @param locationPlacement
	 */
	public SimpleFrame(int locationPlacement){
		setTitle("RP");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		locationInit(locationPlacement);
		
	}
	
	private void locationInit(int num){
		//to get frame to appear at lower bottom right
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        
		if(num == 1){
	        int x = (int) rect.getMaxX() - getWidth();
	        int y = (int) rect.getMaxY() - getHeight();
	        setLocation(x, y);
			//--end of frame at lower bottom right
		}else if(num == 2){
			int x = (int) rect.getMaxX() - getWidth();
	        int y = 0;
	        setLocation(x, y);
		}else{
			setLocationRelativeTo(null);
		}
	}
	
	public void clear(){
		Container frame = this.getContentPane();
		frame.removeAll();
		frame.revalidate();
		frame.repaint();
	}
}
