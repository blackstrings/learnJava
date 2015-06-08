package com.xai.enumeration;

//this is called the enum template method
public enum Toy {
	DOLL(){
		@Override public void execute(){
			System.out.println("is doll");
		}
	},
	PONY(){
		@Override public void execute(){
			System.out.println("is pony");
		}
	};
	public abstract void execute();
	
	//test - this allow you to call execute instead of writing if-else to check if the enum is this or that
	public static void main(String[] args){
		
		System.out.println("test");
		Toy.PONY.execute();
		//getEnum().execute();
	}
}
