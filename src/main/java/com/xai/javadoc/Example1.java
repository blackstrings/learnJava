package com.xai.javadoc;

/*
 @author (classes and interfaces only, required)
 @version (classes and interfaces only, required. See footnote 1)
 @param (methods and constructors only)
 @return (methods only)
 @exception (@throws is a synonym added in Javadoc 1.2)
 @see
 @since
 @serial (or @serialField or @serialData)
 @deprecated (see How and When To Deprecate APIs)
 */

/**
 * This class demonstrates proper java documentation
 * 
 * @author xlao
 * 
 */
public class Example1 {

	/**
	 * Constructor
	 */
	public Example1() {
		// TODO something here
	}

	/**
	 * @deprecated no longer used because it doesn't literally nothing
	 */
	public void method1() {
		int sum = 3 + 10;
		// we add
	}

}
