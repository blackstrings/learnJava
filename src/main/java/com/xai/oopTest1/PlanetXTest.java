package com.xai.oopTest1;

/*
 * When testing in JUnit it is not necessary to test getters/setters functions as they are too
 * obvious. What you should test for are functions that does more than getter/setters.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;

//import org.powermock.reflect.Whitebox; 	// requires POM to work

// @RunWith(PowerMock.class)	// requires pom to work
// @PrepareForTest({PlanetX.class})	// requires pom to work
public class PlanetXTest {

	/* BASIC STRING TEST */
	// ----------------------------------------- //
	String message = "New World";
	
	
	String send(){
		return "New World";
	}
	
	boolean canSend(){
		return true;
	}
	
	@Test
	public void stringTest(){
		String msg = message;
		assertEquals("Strings do not match", msg, send() );
	}
	
	@Test
	public void canSendTest(){
		assertTrue("Message should be able to send", canSend() );
	}
	
	@Test
	public void canSend2Test(){
		assertFalse(canSend() );
	}
	// End of Basic String Test 
	// ----------------------------------------- //
	
	
	
	
	// testing addLvl function in PlanetX
	@Test
	public void addLvlTest(){
		PlanetX px = new PlanetX();	// create instance of object
		assertEquals("Planet lvl should be 2 when calling this function", 2, px.addLvl() );
	}
	
	
	
	

}