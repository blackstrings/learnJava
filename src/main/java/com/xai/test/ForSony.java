package com.xai.test;

public class ForSony {

	int age = 0;
	
	public ForSony(int age){
		this.age = age;			//the use of this
	}
	
	public static void main(String[] args){
		
		//------------------------------------------
		//converting String values to numbers
		//------------------------------------------
		String str = "9";
		int toNumber = Integer.valueOf(str);
		double toDouble = Double.valueOf(str);
		float toFloat = Float.valueOf(str);
		
		
		//test
		
		//------------------------------------------
		//String class methods - just know substring and charAt
		//------------------------------------------
		//substring takes a certain chunk out of the string and returns it into another string variable
		String str1 = "some string";
		String str2 = str1.substring(0, 5);	//grabs the characters starting at index 0, up to index 5	= "some"
		System.out.println(str2);	// will print out "some"
		char c = str1.charAt(0);	//you'll get the character 's' from "some"
		
		
		
		
		//------------------------------------------
		//overloading methods
		//------------------------------------------
		//When a method has the same METHOD_NAME but different arguments
		//All these "run" methods are in the same class, then they are overloading methods
		//you call the method you want by passing the the matching argument
		//public void run()
		//public void run(int speed)
		//public void run(int speed, String type)
		//see overloaded method comments below this main class
		

		
		
		//------------------------------------------
		//passing and returning objects to methods
		//------------------------------------------
		//void means we are not returning an object
		// if void the method will not return any object type
		// if not void, then it will return an object type
		/*
		
		public void add( Student stud ){
			//do something with the incoming stud	
		}
		
		public int add( Student stud){
			//do something
			//then finally return an int type
			int num = 10;
			return num;
		}
		
		*/
		
		
		
		
		//------------------------------------------
		//aggregation
		//------------------------------------------
		//simply just adding something to something
		//to aggregate strings
		String str3 = "Hello";
		String str4 = "World";
		String finalStr = str3 + str4;	//this is string aggregaton by using the + symbol to add strings together
		
		
		
		
		//------------------------------------------
		//shadowing and this
		//------------------------------------------
		//don't worry about shadow, but know this more
		//shadow is having the same variable name for global and local scope
		//this is when you want to refere to the class itself
		
		//this is when you are inside a class and you refer to the class object, use this
		//usually you see this in modify constructor
		//this.run();
		
		
		
		//------------------------------------------
		//arrays—elements, indexes, length, creating and using
		//------------------------------------------
		int[] intArr = new int[10];
		//assigning array to values
		intArr[0] = 55;
		intArr[1] = 99;
		intArr[2] = 103;
		//can only go up to index 9
		intArr[9] = 1000;
		//intArr[10] = 5000; 	// ERROR out of index array exception will occur
		
		//to print array at a index
		System.out.println(intArr[0]);
		
		//to loop the entire array
		for(int i=0; i<intArr.length; i++){
			System.out.println(intArr[i]);
		}
		
		
		
		//------------------------------------------
		//partially-filled arrays
		//------------------------------------------
		//bascially if you use regular arrays int[] you will be creating a partial array
		//meaing you estimate and give it a size you think the array will carry, that itself is called a partial array
		//whe you do that
		int[] myArr = new int[100];	//this is a partial array because i don't know how many numbers I'll be holding in this array
		
		
		
		//------------------------------------------
		//passing and returning arrays into methods
		//------------------------------------------
		//look at my add(int number) method below this main method
		
		
		//------------------------------------------
		// arrays of objects
		//------------------------------------------
		//basically int[] String[] are arrays of objects
		//if you create your own classes
		//then you can do soemthing like this
		//Student[] studArr = new Studnet[10];
		
		
		//------------------------------------------
		//inheritance—base classes and derived classes
		//------------------------------------------
		//when a child extends a parent
		//a child will have all of parents public methods and variables

		/*
		public Dog extends Animal {
		
		}
		*/
		
		//------------------------------------------
		// overriding methods
		//------------------------------------------
		//when a child class has the exact same method signature as the parent class
		//and the child calls this method that is also implemented in the parent calss,
		//the child method will be called instead of the parent method
		
		/*
		 * example
		
		public class Bird{
		 	public void fly(){
		 		sys.out.print(" bird fly");
		 	}
		}
		
		public class Eagle extends Bird {
		
			//this method overrides the parent class fly
			public void fly(){
				sys.out.print(" eagle fly");
			}
		}
		
		//inside a main clas
		Eagle eagle = new Eagle();
		eagle.fly();					//will print out eagle fly, and not bird fly
		  
		 
		 */
		
	}
	
	//example of passing object into method
	//also example of overloaded method
	public void run(int speed){
		//do something with speed, anything
		speed++;
	}
	
	//overloaded method 2
	public void run(){
		
	}
	
	//overlaoded method 3
	public void run(String type){
		
	}
	
	public void add(int[] someArray){
		
		System.out.println("the incoming array passed into this method has size of " + someArray.length);
		
	}
	
}
