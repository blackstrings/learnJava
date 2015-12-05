package com.xai.gui.jframe.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MemFrame extends JFrame {

	
	
	public MemFrame(){
		init();
		loadWelcomeScreen();
	}
	
	public void init(){
		setTitle("Memory");
		Dimension mainSize = new Dimension(300,300);
		setSize(mainSize);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
	}
	
	public void loadWelcomeScreen(){
		clearFrame();
		
		JPanel layoutPanel = new JPanel(new BorderLayout());
		layoutPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		layoutPanel.setBackground(Color.BLACK);
		this.add(layoutPanel);
		
		//title
		String text1 = "<html><font size=+2 color=red>The</font> <font color=white>Memory</font></html>";
		JLabel title = new JLabel(text1);
		title.setPreferredSize(new Dimension(this.getWidth(), 50));
		title.setBackground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		//title.setFont(new Font("Serif", Font.BOLD, 10));
		layoutPanel.add(title, BorderLayout.NORTH);
		
		//copryright
		String text2 = "<html><font color=white> copyright&copy;2015 </font></html>";
		JLabel copyright = new JLabel(text2);
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		layoutPanel.add(copyright, BorderLayout.SOUTH);
		
		//start button
		JButton startBtn = new JButton();
		startBtn.setBackground(Color.WHITE);
		String startBtnTxt = "<html><font color=white size=+1>START</font></html>";
		startBtn.add(new JLabel(startBtnTxt) );
		//startBtn.setForeground(Color.WHITE);
		startBtn.setPreferredSize(new Dimension(100,30));
		startBtn.setOpaque(false);
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadRound();
			}
		});
		JPanel flowLayout = new JPanel(new FlowLayout());
		flowLayout.setBackground(Color.BLACK);
		flowLayout.add(startBtn);
		layoutPanel.add(flowLayout, BorderLayout.CENTER);
		
		
	}
	
	public void loadRound(){
		clearFrame();
		
		//test
		int[] memoryArr = new int[]{0,1,2,3,4};
		
		//container
		JPanel layoutPanel = new JPanel(new BorderLayout());
		layoutPanel.setBackground(Color.BLACK);
		this.add(layoutPanel);
		
		//header (count down timer, round);
		JPanel headerPanel = new JPanel(new BorderLayout());
		layoutPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.add(new TimerLabel());
		
		//body
		JPanel bodyPanel = new JPanel();
		layoutPanel.add(bodyPanel, BorderLayout.CENTER);
		
		//footer (3 buttons go)
		JPanel footerPanel = new JPanel();
		layoutPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	public void loadGameoverScreen(){
		clearFrame();
		
	}
	
	public void clearFrame(){
		Container frame = this.getContentPane();
		frame.removeAll();
		frame.revalidate();
		frame.repaint();
	}
	
	
	
}
