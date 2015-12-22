package com.xai.gui.jframe.rp.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.xai.gui.jframe.rp.RService;
import com.xai.gui.jframe.rp.domain.Mon;
import com.xai.gui.jframe.rp.domain.User;

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
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width,height);
	}
	
	private void init(){
		serv = new RService();
		loadScreen100();
	}
	
	private void loadScreen100(){
		clear();
		JPanel p = new JPanel(new BorderLayout());
		add(p);
		
		//top
		p.add(new JLabel("S Y Mon"){
			{
				setHorizontalAlignment(CENTER);
			}
		}, BorderLayout.NORTH);
		
		//center - if you want to custom paint the components inside a jpanel
		/*
		JPanel center = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				MonGui mg2 = new MonGui(serv.getRandMon());
				mg2.paintComponent(g);
				MonGui mg3 = new MonGui(serv.getRandMon());
				mg3.paintComponent(g, 55,0);
				
				
			}
		};
		p.add(center, BorderLayout.CENTER);
		*/
		
		JPanel center = new JPanel();
		p.add(center, BorderLayout.CENTER);
		
		MonGui mg;
		for(int i=0; i<3; i++){
			mg = new MonGui(serv.getMonById(i+1001));
			mg.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseClicked(MouseEvent e) {
					Mon mon = ((MonGui)e.getSource()).getMon();
					Mon copyMon = new Mon(mon);
					serv.addToUser(copyMon);
					loadScreen101();
				}
			});
			center.add(mg);
		}
		
		
	}
	
	private void loadScreen101(){
		clear();
		
		JPanel p = new JPanel(new BorderLayout());
		add(p);
		
		p.add(new JLabel("inbox"), BorderLayout.NORTH);
		
		Mon mon = serv.getUser().get(0);
		String monInfo = mon.toString();
		JTextArea a = new SimpleTextArea(monInfo, 4,10, 5);
		p.add(a, BorderLayout.CENTER);
		
		//btns
		JPanel btnPnl = new JPanel();
		p.add(btnPnl, BorderLayout.SOUTH);
		
		//keep
		JButton keepBtn = new JButton("Keep");
		keepBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadScreen102();
			}
		});
		btnPnl.add(keepBtn);
		
		//repick
		JButton repickBtn = new JButton("RePick");
		repickBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				serv.getUser().removeMon(0);
				loadScreen100();
			}
		});
		btnPnl.add(repickBtn);
		
	}
	
	private void loadScreen102(){
		clear();
		
	}
	
	public void clear(){
		Container frame = this.getContentPane();
		frame.removeAll();
		frame.revalidate();
		frame.repaint();
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
