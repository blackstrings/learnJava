package com.xai.junits;

import org.junit.Assert;
import org.junit.Test;

public class JunitDemoTest {

	@Test
	public void addFourTest(){
		JunitDemo jd = new JunitDemo();
		int result = jd.addOne(1);
		Assert.assertEquals(5, result);
	}
	
}
