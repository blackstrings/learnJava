package com.xai.gui.jframe.rp.gui;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.xai.gui.jframe.rp.RService;
import com.xai.gui.jframe.rp.User;
import com.xai.gui.jframe.rp.domain.Mon;

public class RFrame extends JFrame {

	private int width = 200;
	private int height = 150;
	private RService serv;
	
	public RFrame(){
		setTitle("RP");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//to get frame to appear at lower bottom right
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - getWidth();
        int y = (int) rect.getMaxY() - getHeight();
        setLocation(x, y);
		//--end of frame at lower bottom right
		init();
		test();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width,height);
	}
	
	private void init(){
		serv = new RService();
	}
	
	private void test(){
		for(int i=0; i<1; i++){
			serv.addToUser(serv.getRandMon());
		}
		User user = serv.getUser();
		Mon m1 = user.get(0);
		Mon m2 = serv.getRandMon();
		boolean stat = serv.match(m1, m2);
		if(stat){
			System.out.println("w");
		}else{
			System.out.println("l");
		}
		System.out.println(serv.getUser());
	}
	
}
