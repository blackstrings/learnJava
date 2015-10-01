package com.xai.program.rockpaper;

import com.xai.program.rockpaper.Hand.TYPE;

public class Match {
	
	private Player p1;
	private Player p2;
	private String outCome = "";
	
	public Match(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
		begin();
	}

	private void begin(){
		TYPE p1HandType = p1.getHand().getType();
		TYPE p2HandType = p2.getHand().getType();
		
		if(p1HandType == TYPE.Paper){
			
			if(p2.getHand().getType() == TYPE.Paper){
				outCome = "Draw";
			}else if(p2HandType == TYPE.Rock){
				outCome = p1.toString();
			}else if(p2HandType == TYPE.Sisscor){
				outCome = p2.toString();
			}
			
		}else if(p1HandType == TYPE.Rock){
			
			if(p2HandType == TYPE.Rock){
				outCome = "Draw";
			}else if(p2HandType == TYPE.Sisscor){
				outCome = p1.toString();
			}else if(p2HandType == TYPE.Paper){
				outCome = p2.toString();
			}
			
		}else if(p1HandType == TYPE.Sisscor){
			
			if(p2HandType == TYPE.Sisscor){
				outCome = "Draw";
			}else if(p2HandType == TYPE.Paper){
				outCome = p1.toString();
			}else if(p2HandType == TYPE.Rock){
				outCome = p2.toString();
			}
			
		}
	
		
	}
	
	public String toString(){
		return outCome;
	}
}
