package com.xai.gui.jframe.basic;

import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;

public class JFrameDemoBasic extends JFrame {
	public JFrameDemoBasic() {
		// Set JFrame title
		super("Draw A Circle In JFrame");

		// Set default close operation for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set JFrame size
		setSize(400, 400);

		// Make JFrame visible
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);

		// draw circle outline
		g.drawOval(50, 50, 100, 100);

		// set color to RED
		// So after this, if you draw anything, all of it's result will be RED
		g.setColor(Color.RED);

		// fill circle with RED
		g.fillOval(50, 50, 100, 100);
	}

	public static void main(String[] args) {
		JFrameDemoBasic dlijf = new JFrameDemoBasic();
	}
}