package com.xai.generic;

/*
 * Generic Methods allows you to pass in any type objects
 */
public class MainGeneric {

	/*
	 * MAIN
	 */
	public static void main(String [] args){
		
		// Generic test
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.0, 2.0, 3.0, 4.0 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array intergerArray contains: ");
		printArray(intArray);

		System.out.println("Array doubleArray contains: ");
		printArray(doubleArray);

		System.out.println("Array characterArray contains: ");
		printArray(charArray);

		// Generic bounded by type test
		System.out.printf("Highest of %d, %d, %d is: %d\n\n", 24, 32, 22,
				getHighestNumberBetweenThreeNumbers(24, 32, 22));
		
		// Generic highest in the array
		Integer[] intArr = { 33,13,25,31,36,32,12,36,21,83,35,22 };
		System.out.println("Highest in array is: " + getHighestNumberInArray(intArr) );
		
	}
	
	/*
	 * generic method <E> before return type
	 */
	public static <E> void printArray(E[] inputArray) {

		// display array elements
		for (E element : inputArray) {
			System.out.printf("%s", element);
		}

		System.out.println();
	}

	/*
	 * generic method bounded by type <T extends boundType<T>>
	 */
	public static <T extends Comparable<T>> T getHighestNumberBetweenThreeNumbers(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0) {
			max = y;
		}
		if (z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}
	
	
	public static <T extends Comparable<T>> T getHighestNumberInArray(T[] list){

		T highest = list[0];
		
		for(T item : list){
			
			if(item.compareTo(highest) > 0){
				highest = item;
			}
			
		}
		
		return highest;
	}

}
