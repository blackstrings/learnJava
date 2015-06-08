package com.xai.enumeration;


import java.util.ArrayList;

/**
 * for junits, use org.junit package instead of the framework as the framework is deprecated
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainEnumTest {
	EnumDemo.Planet p;
	
	/**
	 * Create object before every test
	 */
	@Before
	public void createEnum(){
		p = EnumDemo.Planet.EARTH;
	}
	
	/**
	 * Test to see if object is null
	 * @return void
	 */
	@Test
	public void objNotNullTest(){
		EnumDemo obj = new EnumDemo();
		Assert.assertTrue(obj != null);
	}
	
	/**
	 * check that Planet.EARTH's ID is 10
	 */
	@Test
	public void plantIdMatchTest(){
		Assert.assertEquals(10, p.getId());
	}
	
	/**
	 * Check that Planet.EARTH ID is not below 10
	 */
	@Test
	public void planetIdFailTest(){
		if( p.getId() <= 9){
			Assert.fail();
		}
	}
}
