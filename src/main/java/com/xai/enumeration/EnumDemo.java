package com.xai.enumeration;

public class EnumDemo {

	/*
	 * enum 1 - embedded inside a class
	 */
	public enum DAY { 
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY 
	}
	
	/*
	 * enum 2 - enum with fields and constructor
	 */
	public enum Planet {
		EARTH (10),
		MARS (20);
		
		private int id;
		
		private Planet(int id){
			this.id = id;
		}
		
		public int getId(){
			return id;
		}
	}
	
	/*
	 * enum 3 - override toString
	 */
	public enum Color {
		WHITE, BLACK, BLUE, 
		
		//deprecating a enum value, combine the both below for best documentation
		/**
		 * @deprecated use WHITE instead
		 */
		@Deprecated
		white;
		
		@Override
		public String toString(){
			String str = super.toString();
			return str;
		}
	}
	
	/*
	 * MAIN
	 */
	public static void main(String[] args){
		// enum 1
		DAY d = DAY.SUNDAY;
		System.out.println("Enum 1: " + d);	
		//prints
		//SUNDAY
		
		// enum 2
		Planet planet = Planet.EARTH;
		System.out.print("Enum 2: " + planet + ", ");
		System.out.println("ID: " + planet.getId());
		//prints
		//EARTH, ID: 10
		
		// enum 3
		Color color = Color.BLACK;
		Color color2 = Color.white;
		Color color1 = Color.WHITE;
		System.out.println("Enum 3: " + color);
		//prints
		// WHITE
		System.out.println(color.ordinal());
		System.out.println(color.hashCode());
		System.out.println(color1.hashCode());
		
		System.out.println(color1.name());
		System.out.println(Color.valueOf(Color.WHITE.toString()));
		System.out.println(Color.valueOf(Color.WHITE.name()));
	}
	
}
