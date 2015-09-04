package com.xai.junits;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class JClassUtilsDemo {

	@Test
	public void test(){
		
		JClassObj obj = Mockito.mock(JClassObj.class);
		
		
		Mockito.when(obj.canHide()).thenReturn(false);
		
		boolean result = obj.canHide();
		
		Assert.assertTrue(!result);
		
	}
}
