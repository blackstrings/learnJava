package com.xai.gametest2;

/**
 * Determines the kind of fish that can be caught
 * Fishes that are too big can snap the line
 * Fishes that are too small may not be attracted as much to bait
 * 
 * for more line info 	http://www.bassfishin.com/blog/fishing-line-guide/
 * 
 *
 */
public enum FishingLineType {

	LBS01(1.0),LBS02(2.0),LBS04(4.0),
	LBS06(6.0),LBS08(8.0),LBS10(10.0),
	LBS12(12.0),LBS14(14.0),LBS16(16.0),
	LBS18(18.0),LBS20(20.0),LBS22(22.0),
	LBS24(24.0),LBS26(26.0),LBS28(28.0),
	LBS30(30.0),LBS32(32.0),LBS34(34.0),
	LBS36(36.0),LBS38(38.0),LBS40(40.0),
	LBS42(42.0),LBS44(44.0),LBS46(46.0),
	LBS48(48.0),LBS50(50.0),LBS52(52.0),
	LBS54(54.0),LBS56(56.0),LBS58(58.0),
	LBS60(60.0),LBS62(62.0),LBS64(64.0),
	LBS66(66.0),LBS68(68.0),LBS70(70.0),
	LBS72(72.0),LBS74(74.0),LBS76(76.0),
	LBS78(78.0);
			
	private double val;
	FishingLineType(double val){
		this.val = val;
	}
	public double val(){return val;}
	
	
	// Enum generator (LBSxx - however many you want)
	/*
	public static void main(String [] args){
		
		for(int i=0; i<80; i++){
			
			if(i<10){ 	// to generate 0's for 1-9
				if(i%2 == 0){
					if(i%6 != 0 ){
						System.out.print("LBS0"+i +"(" + i + ".0" + ")" + ",");
					}else{
						System.out.println();
						System.out.print("LBS0"+i +"(" + i + ".0" + ")" + ",");
					}
				}
			}else{		// to not generate 0's since we are above 9
				if(i%2 == 0){
					if(i%6 != 0 ){
						System.out.print("LBS"+i +"(" + i + ".0" + ")" + ",");
					}else{
						System.out.println();
						System.out.print("LBS"+i +"(" + i + ".0" + ")" + ",");
					}
				}
			}
			
		}
		
	}*/
	
}
