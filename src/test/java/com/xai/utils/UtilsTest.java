package com.xai.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * for junits, use org.junit package instead of the framework as the framework is deprecated
 */


public class UtilsTest {

	@Test
	public void addFourTest(){
		
		Utils ut = new Utils();
		//
		
		int result = ut.addFour(1);
		Assert.assertEquals(5, result);
	}
	
}
