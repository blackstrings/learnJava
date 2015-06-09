//package com.xai.junits;
//
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.rule.PowerMockRule;
//import org.powermock.reflect.Whitebox;	// to use whitebox to invoke private method or to set internal class variables
//
//@PrepareForTest({TestClassA.class, TestClassB.class})
//@RunWith(PowerMockRunner.class)
//public class Junits {
//
//	
//	
//	@Test
//	public void test(){
//		
//		
//		/**---------------------------------------------------**/
//		//	Enums 			   			   					   //
//		/**---------------------------------------------------**/
//		// You don't mock enums because they are public, if you do, just make sure to get a correct
//		// return value of that enum
//		//ex.
//		MyType.TYPE1;	// just call it directly
//		
//		
//		/**---------------------------------------------------**/
//		//	Lists			   			   					   //
//		/**---------------------------------------------------**/
//		
//		// You should try not to mock lists, instance it instead
//		// and pass it as a return item if possible
//		// but you may want to mock the item being added to the list
//		List<ProductDTO> products = new ArrayList<ProductDTO>();
//		
//		ProductDTO product = Mockito.mock(ProductDTO.class);
//		products.add(product);
//		
//		/**---------------------------------------------------**/
//		//	Hi-Jack local variables inside methods			   //
//		/**---------------------------------------------------**/
//		
//		//just make sure to match the right type for what you want to inject
//		ArrayList<String> fqList = new ArrayList<String>();
//		PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(fqList);	// no arguments
//		
//		ClassA classA = Mockito.mock(ClassA.class);
//		PowerMockito.whenNew(Area.class).withAnyArguments().thenReturn(classA);		// with any arguments
//
//		/**---------------------------------------------------**/
//		//	Hi-Jack and set private/public variables inside methods //
//		/**---------------------------------------------------**/
//		
//		Map<Double, Integer> internalBeam = new HashMap<Double, Integer>();
//		Whitebox.setInternalState(estBeam, "internalBeam", internalBeam);
//		
//		Map<Double, Integer> edgeBeam = new HashMap<Double, Integer>();
//		Whitebox.setInternalState(estBeam, "edgeBeam", edgeBeam);
//		
//		/**---------------------------------------------------**/
//		//	Basic mockito when //
//		/**---------------------------------------------------**/
//		
//		//must first mock/stub the object
//		Beam beam = Mockito.mock(Beam.class);
//		
//		//single return
//		Mockito.when(beam.getLabel()).thenReturn("Internal_Water_Beam");
//		
//		//multiple returns, each iterate will go to the next
//		Mockito.when(beam.getLabel()).thenReturn(
//				"Internal_Water_Beam",									// 1st iterate pattern
//				"Internal_Beam", "Internal_Beam",						// 2nd iterate pattern
//				"Edge_Beam", "Edge_Beam", "Edge_Angled_Beam");			// 3rd iterate pattern + 4th and so on will use the last position
//		
//		/**---------------------------------------------------**/
//		//  Inside Private return Methods (Non-Static)	       //
//		/**---------------------------------------------------**/
//		
//		// instead of DeckCategoryId.ZIP_UP_EXTERIOR_WALL_TRIM_CATEGORY_ID) you can use
//		// Long.class if that's what it results too
//		PowerMockito.stub(PowerMockito.method(TestingClass.class, "privateMethod", Param1.class, Param2.class)).toReturn(MockObject);
//		
//		/**---------------------------------------------------**/
//		//  Inside private void method		  		   		   //
//		/**---------------------------------------------------**/
//		
//		/** DO NOT use PowerMockito.mockStatic(EstUnderDecking.class); 
//		 * otherwise your spies will not work correctly
//		 * mockStatic will stub all method regardless if you mockito.CallRealMethod -- strange... i know
//		 * **/
//		
//		//spy the class
//		EstUnderDecking estSpy = PowerMockito.spy(new EstUnderDecking());
//		//do nothing when the spyObject's method is called
//		PowerMockito.doNothing().when(estSpy, "incrementRunningLengths", Mockito.anyDouble());
//		//calls the real method
//		PowerMockito.doCallRealMethod.when(estSpy, "incrementRunningLengths", Mockito.anyDouble());
//		//return something when method is called
//		PowerMockito.doReturn(object).when(estSpy, "incrementRunningLengths", Mockito.anyDouble());
//		
//		//OR
//		
//		//you want to suppress it instead so the method won't run
//		PowerMockito.suppress(PowerMockito.method(TestingClass.class, "PrivateOrPublicMethod"));	//don't run this method
//		
//		//run the method
//		
//		//verify here if need
//		PowerMockito.verifyPrivate(estSpy, Mockito.times(1)).invoke("privatePublicMethod", Mockito.any(Class.class));
//		
//		
//		
//		
//		
//		/**---------------------------------------------------**/
//		//  Inside private static return method		  		   //
//		/**---------------------------------------------------**/
//		
//		//mock return when inside class private static method is called
//		//NOTE: This will actually run the real method meaning it'll go inside the method
//		// if you do not want to go inside, use PowerMockito.mockStatic(ClassYouAreTesting.class) in combination with this below
//		// PrepareForTest() ....make sure to put class in there
//		PowerMockito.stub(PowerMockito.method(ClassYouAreTesting.class, "handrailIsWood")).toReturn(true);
//		
//		
//		/**---------------------------------------------------**/
//		//  Inside Public static return method 	 			  	   //
//		/**---------------------------------------------------**/
//		
//		Profiler profile = Mockito.mock(Profiler.class);
//		PowerMockito.when(profile.getModel()).thenReturn(mockObject);
//		
//		
//		/**---------------------------------------------------**/
//		//  Outside Private Static return method				  	   //
//		/**---------------------------------------------------**/
//		
//		//mock when outside class private static method is called (can only do one time mock however)
//		// this will mock and ignore all static method calls of this class
//		// PrepareForTest() ....make sure to put class in there
//		// also add @RunWith(PowerMockRunner.class) below preparefortest
//		PowerMockito.stub(PowerMockito.method(OutSideClass.class, "getNumberOfBottomRails")).toReturn(100);
//		
//		
//		/**---------------------------------------------------**/
//		//  Outside Public static return method 	 			  	   //
//		/**---------------------------------------------------**/
//		
//		//method A: not using Mockito.when, and just one return
//		PowerMockito.stub(PowerMockito.method(ProductBO.class, "findProductsById", 
//				List.class)).toReturn(products);
//		
//		//Method B: using Mockito.when, and multiple returns
//		// use this when the outside public static method is called two or more in chain 
//		// it will mock all static method calls due to mockStatic()
//		// all returns will be null unless specified
//		/** MAKE SURE TO INCLUDE CLASS IN @prepareForTest() */
//		PowerMockito.mockStatic(RailingUtils.class); // will mock all methods, in otherwords, bypass, ignore all methods
//		//or
//		PowerMockito.doNothing().when(RailingEstimationBA.class);
//		// if matchings are used,
//		// all parameters should use it -> any(), can't just do one match
//		PowerMockito.when(RailingUtils.getNumberOfBottomRails(
//				Mockito.anyListOf(Level.class))).thenReturn(100, 300, 400);
//		//OR
//		PowerMockito.when(SearchBO.findByCategory(
//				Mockito.anyLong(), Mockito.anyInt()).thenReturn(searchResult);
//
//		/**---------------------------------------------------**/
//		//  Outside Public static void method	 	   //
//		/**---------------------------------------------------**/
//		
//		// @PrepareForTest({Static.class}) <--- put in there too
//		// all static methods of this class should be stubbed/bypassed/ignore/not run
//		PowerMockito.mockStatic(Static.class);
//		
//		//*************
//		//if static method takes parameter, make sure that all static method's parameters are not null and should be mock
//		// or you will get ERORR
//		//ex. ItemContainerBA.addToProfile(profile, item.getID(0), 4);
//		// if item is null, ItemContainerBA will always throw a fit, mock it and you should be good
//		
//		//run method
//		TestClass testClass = Mockito.mock(TestClass.class);
//		testClass.publicMethod();
//		//or
//		Whitebox.invokeMethod(testClass, "privateMethod", param1, param2);
//		
//		//the second line tells mockito what static class and method to match for the # of times in line 1
//		PowerMockito.verifyStatic(Mockito.times(1));
//		ItemContainerBA.addItemToProfile(Mockito.any(Class.class), Mockito.any(Class.class));
//		
//		
//		/**---------------------------------------------------**/
//		//  Outside Public void method	 	  				   //
//		/**---------------------------------------------------**/
//		
//		SomeClass someClass = Mockito.mock(SomeClass.class);
//		PowerMockito.whenNew(SomeClass.class).withAnyArguments().thenReturn(someClass);
//		Mockito.doCallRealMethod().when(someClass).publicMethod(someArgument);
//		
//		//if need to verify use any of below
//		Mockito.verify(someClass).setDefaultValue(newDefaultValue);
//		Mockito.verify(someClass).publicMethod();	// 1 time
//		Mockito.verify(someClass, Mockito.times(3)).publicMethod();	// 3 times
//		
//		
//		/**---------------------------------------------------**/
//		//  Verify - Outside Public static void method	 	   //
//		/**---------------------------------------------------**/
//		
//		// ex: http://www.gitshah.com/2010/05/how-to-partially-mock-class-and-its.html
//		// @PrepareForTest({ItemContainerBA.class}) <--- put in there too
//		PowerMockito.mockStatic(ItemContainerBA.class);
//		
//		//test the private static method
//		Whitebox.invokeMethod(estWoodRail, "estimateWoodBottomRailFasteners", profile, 100);
//		
//		/** verify outside class public static */
//		//Verify outside class public static method was reached
//		PowerMockito.verifyStatic(Mockito.times(1));
//		// combine top code with bottom code, it pairs up
//		ItemContainerBA.methodA(Mockito.any(ClassA.class), 
//			Mockito.anyLong(), 
//			Mockito.anyDouble(),
//			Mockito.any(WhereUsed.class));
//		
//		/** Verify a 2nd outside class public static method, have to do a separate
//		 *  verify for each public static method */
//		PowerMockito.verifyStatic(Mockito.times(2));
//		// combine top code with bottom code, it pairs
//		ItemContainerBA.methodB(Mockito.any(ClassB.class), 
//			Mockito.anyLong());
//		
//		
//		
//		/**---------------------------------------------------**/
//		//  Verify - Inside Private static return method 	 		   //
//		/**---------------------------------------------------**/
//		
//		// ex: http://java.dzone.com/articles/why-use-powermock-mock-private
//		/**################   Verify & bypass inside class private static method calls, but DON't RUN it ################ */
//		PowerMockito.mockStatic(EstWoodRail.class, Mockito.CALLS_REAL_METHODS);
//		PowerMockito.suppress(PowerMockito.method(EstWoodRail.class, "estimateWoodBottomRailFasteners"));	//don't run this method
//		
//		//set up spy if needed - 
//		EstUnderDecking estSpy = PowerMockito.spy(new EstUnderDecking());	//if test case is not static
//		//method you want to spy on
//		PowerMockito.doNothing().when(estSpy, "privateOrPublicMethod", Mockito.any(Class.class), Mockito.anyInt());
//		
//		//run/invoke the method, use one or the other and follow up in combination with the correct ex below
//		EstWoodRail.estBottomRail(profileId);										//test case is public
//		Whitebox.invokeMethod(spyMock, "privateMethod", Mockito.any(Class.class));	//test case is private
//	
//		//When you just need to verify that a certain method was called or reached
//		//PowerMockito.verifyStatic(Mockito.times(1));
//		
//		// NOTE: Add this below only if you want to verify - otherwise don't need the below
//		//Verify class's inner private static method
//		//ex1
//		PowerMockito.verifyPrivate(ClassYouAreTesting.class, 
//				Mockito.times(1)).invoke("PrivateOrPublicMethod",
//				Mockito.any(DeckEstimationProfile.class), 
//				Mockito.anyInt());
//		//ex2
//		PowerMockito.verifyPrivate(spyMock).invoke("handrailIsWood",
//				Mockito.any(DeckModelDTO.class));
//		
//		//########### Verify an object's public method is called once ###### // use after test method is run of course
//		Mockito.verify(mockObject, Mockito.times(1)).mockObjectMethod(); // OR
//		Mockito.verify(mockObject).mockObjectMethod(); // equivalent to using times(1)
//		
//		//########### Verify multiple methods called from same object 
//		// Note: should be put together with verifyPrivate codes with these keep them separate or error will occur
//		Mockito.verify(deckModel, Mockito.times(1)).hasRailing();
//		Mockito.verify(deckModel, Mockito.times(2)).getRailingCategoryInfo();
//		
//		
//		/**---------------------------------------------------**/
//		// Catching argument or value when a method is called  //
//		// Outside public static method						   //
//		/**---------------------------------------------------**/
//		
//		//prepare to verify a outside public static method inside testing method
//		PowerMockito.mockStatic(RailingEstimationBA.class);
//		
//		//run the method first
//		ClassA.calculate();
//		
//		//verify method was reached and called once
//		PowerMockito.verifyStatic(Mockito.times(1));
//		
//		//catch what type : double argument
//		ArgumentCaptor<Double> argument = ArgumentCaptor.forClass(Double.class);
//		
//		//when this method runs, catch the argument
//		ClassA.methodA(argument.capture(), Mockito.anyInt());
//		
//		//test
//		Assert.assertEquals(1.0, argument.getValue());
//		//----------------------------------------------------------------------------------//
//	}
//	
//}
