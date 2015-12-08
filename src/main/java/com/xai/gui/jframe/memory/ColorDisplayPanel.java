package com.xai.gui.jframe.memory;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

/**
 * responsible for rendering/displaying the selected colors that are pressed at runtime
 */
public class ColorDisplayPanel extends JPanel {

	//the starting of each round will not render any inputs in the display view
	public boolean canRenderInputs = false;
	
	public ColorDisplayPanel(){
		setLayout(new FlowLayout(0));
		setBackground(Color.WHITE);
	}
	
	/*
	List<Integer> inputsSoFar;
	
	//when a new input is sent use this method to update the screen
	public void updateScreen(List<Integer> inputsSoFar){
		canRenderInputs = true;
		this.inputsSoFar = inputsSoFar;
		clearPanel();
	}
	
	//only use this for when you want to use an advance way of drawing the inputs
	//everytime updateScreen is called, this method will redraw the screen
	//do not use the paintCompoents with the s
	//instead use paintComponent without s
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		
		if(canRenderInputs){
			//test width
			int width = 50;
			int height = 50;
			int padding = 5;
			int maxCol = (int) Math.floor(this.getWidth()/(width+padding));	//so we can only render within the boundary of this display width
			int maxRow = (int) Math.floor(this.getHeight()/(height+padding)); //so we can only render within the boundary of this display height
			
			int counter =0;
			
			//the min and max row col we have
			for(int row=0; row<maxRow; row++){
				for(int col=0; col<maxCol; col++){
					
					//the number of paints we can paint
					if(counter < inputsSoFar.size()){
						
						g.setColor(getColor(inputsSoFar.get(counter)));
						g.drawOval(col*(width+padding), 
								row*(height+padding), 
								width, 
								height);
						
						counter++;
						
					}else{
						return;
					}
				
				
				}
				
			}
		}
		
	}
	
	
	private Color getColor(int id){
		if(id == 0){
			return Color.RED;
		}else if(id == 1){
			return Color.GREEN;
		}else if(id == 2){
			return Color.YELLOW;
		}else{
			return Color.LIGHT_GRAY;
		}
	}
	
	private void clearPanel(){
		removeAll();
		revalidate();
		//repaint();
	}
	
	*/
}
