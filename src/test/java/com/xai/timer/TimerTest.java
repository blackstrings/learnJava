package com.xai.timer;

/**
 * for junits, use org.junit package instead of the framework as the framework is deprecated
 */
import org.junit.Assert;
import org.junit.Test;

/**
 * Learning Junit
 * 
 * <p>
 * When you do Junit Testing, you don't want to make any real service calls.
 * Instead you want to mock/bypass everything you can and just test what you need to test.
 * </p>
 */
public class TimerTest {
	
	@Test
	public void methodATest(){
		
		Timer timer = new Timer();
		
		//The assert always comes last to test if you get the result you wanted
		Assert.assertEquals(true, true);
	}
	
	
}
