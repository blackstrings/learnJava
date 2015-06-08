package com.xai.statements;

public class SwitchDemo {

	private enum Switches {
		ON, OFF;
	}
	
	public static void main(String[] args){
		
		//String
		String str = "Tom";
		
		switch(str){
		case "Kim":
			System.out.println("Was Kim");
			break;
			
		case "Tom":
			System.out.println("Was Tom");
			break;
		}
		
		
		//numbers
		int num = 5;
		switch(num){
		case 0:
			System.out.print("It's 0");
			break;
		case 5:
			System.out.println("It's 5");
			break;
		}
		
		//enum
		Switches sw = Switches.ON;
		switch (sw){
			case OFF:
				System.out.println("Is off");
				break;
			case ON:
				System.out.println("Is On");
				break;
		}
	}
	
}
