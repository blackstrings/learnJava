package com.xai.gui.jframe.fps;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.xai.gui.jframe.simple.CustomComp;

/**
 * FPS = frames per second. This demo shows you how to render 
 * animation like by redrawing the screen 30 frames per second.
 * 
 */
public class FPSDemo extends JFrame {
	boolean isRunning = true;
	int fps = 30;
	int windowWidth = 500;
	int windowHeight = 500;

	BufferedImage backBuffer;
	Insets insets;
	InputHandler input;

	int x = 0;
	int y = 0;
	
	CustomComp box;

	public static void main(String[] args) {
		FPSDemo game = new FPSDemo();
		game.run();
		System.exit(0);
	}

	/**
	 * This method starts the game and runs it in a loop
	 */
	public void run() {
		initialize();

		while (isRunning) {
			long time = System.currentTimeMillis();

			update();
			draw();

			// delay for each frame - time it took for one frame
			time = (1000 / fps) - (System.currentTimeMillis() - time);

			if (time > 0) {
				try {
					Thread.sleep(time);
				} catch (Exception e) {
				}
			}
		}

		setVisible(false);
	}

	/**
	 * This method will set up everything need for the game to run
	 */
	void initialize() {
		setTitle("2D Test");
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//box = new CustomComp(50,50);
		//add(box);

		insets = getInsets();
		setSize(insets.left + windowWidth + insets.right, insets.top
				+ windowHeight + insets.bottom);

		backBuffer = new BufferedImage(windowWidth, windowHeight,
				BufferedImage.TYPE_INT_RGB);
		input = new InputHandler(this);
	}

	/**
	 * This method will check for input, move things around and check for win
	 * conditions, etc
	 */
	void update() {
		
		//x += 1;
		
		if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
			x += 1;
		}
		if (input.isKeyDown(KeyEvent.VK_LEFT)) {
			x -= 1;
		}
		if (input.isKeyDown(KeyEvent.VK_UP)) {
			y -= 1;
		}
		if (input.isKeyDown(KeyEvent.VK_DOWN)) {
			y += 1;
		}
		
		 
	}

	/**
	 * This method will draw everything
	 */
	void draw() {
		Graphics g = getGraphics();
		
		//box.getGraphics().drawRect(x, y, 5, 5);

		Graphics bbg = backBuffer.getGraphics();

		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, windowWidth, windowHeight);

		bbg.setColor(Color.BLACK);
		bbg.drawOval(x, y, 20, 20);
		

		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
}