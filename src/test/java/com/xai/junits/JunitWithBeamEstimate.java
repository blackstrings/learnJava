//package com.xai.junits;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentSkipListSet;
//
//import org.apache.commons.logging.LogFactory;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.modules.junit4.rule.PowerMockRule;
//import org.powermock.reflect.Whitebox;
//
//import com.menard.EstimationMethod;
//import com.menard.deck.DeckTestImpl;
//import com.menard.deck.materialList.WhereUsed;
//import com.menard.deck.model.dto.DeckModelDTO;
//import com.menard.deck.profile.DeckEstimationProfile;
//import com.menard.deck.selectable.ProductType;
//import com.menard.deck.shape.Level;
//import com.menard.deck.shape.LevelMock;
//import com.menard.reaf.estimate.Estimate;
//import com.menard.reaf.estimate.EstimateManager;
//import com.menard.reaf.estimate.EstimationProfile;
//import com.menard.reaf.materialList.Product;
//import com.menard.reaf.resourceManager.mcom.dto.ProductDTO;
//import com.menard.reaf.resourceManager.mcom.dto.ProductDTOMock;
//import com.menard.reaf.script.LuaRegistry;
//
///**
// * @author xlao
// *
// */
//@PrepareForTest({LuaRegistry.class, EstimateManager.class, EstBeam.class})
//@RunWith(PowerMockRunner.class)
//public class EstBeamTest {// extends DeckTestImpl {
//	
//	private static  boolean isBeamEstimated = false;
//	
////	@Rule
////	public PowerMockRule rule = new PowerMockRule();
//
////	/**
////	 * Test to see if we can get estimate beam
////	 * 
////	 * @throws Exception
////	 */
////	
////	@Test
////	public void testCanEstimateBeam() throws Exception {
////
////		PowerMockito.mockStatic(LuaRegistry.class);
////		PowerMockito.whenNew(LuaRegistry.class).withAnyArguments().thenReturn(null);
////		
////		// #1 -- Run setup estimation
////		PowerMockito.mockStatic(LogFactory.class);
////		setUpEstimation(EstBeamTest.class, "canEstimateBeamTest", DeckMaterialListTypeTestImpl.Beam);
////		
////		// #2 -- Test the estimation
////		Assert.assertTrue(isBeamEstimated);
////		
////	}
////	
////	@Estimate(estimationProfileId = "beam")
////	public static void canEstimateBeamTest(String profileId) {
////		
////		isBeamEstimated = false;
////		
////		DeckEstimationProfile profile = (DeckEstimationProfile) EstimationProfile.getProfiles().get(profileId);
////		
////		DeckModelDTO deckModel = profile.getModel();
////		profile.setModel(deckModel);
////		
////		// prepare levels
////		List<Level> levels = new ArrayList<Level>();
////		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
////		levels.add(level);
////		deckModel.setLevels(levels);
////		
////		// set products as needed
////		ProductDTO beam = ProductDTOMock.getProductDTOMock();
////		List<ProductDTO> beams = new ArrayList<ProductDTO>();
////		beams.add(beam);
////		deckModel.getProductMap().put(ProductType.BEAM, beams);
////		
////		// beams needs some joists
////		ProductDTO joist = ProductDTOMock.getProductDTOMock();
////		joist.setWidth(7.5);
////		List<ProductDTO> joists = new ArrayList<ProductDTO>();
////		joists.add(joist);
////		deckModel.getProductMap().put(ProductType.JOIST, joists);
////		
////		// beams needs some deckBoards
////		ProductDTO deckBoard = ProductDTOMock.getProductDTOMock();
////		deckBoard.setHeight(1.125);
////		List<ProductDTO> deckBoards = new ArrayList<ProductDTO>();
////		deckBoards.add(deckBoard);
////		deckModel.getProductMap().put(ProductType.DECK_BOARD, deckBoards);
////		
////		// run the estimate
////		try{
////			EstBeam.estimateBeam("beam");
////			isBeamEstimated = true;
////		}catch(Exception e){
////			isBeamEstimated = false;
////		}
////		
////	}
////	
////	/**
////	 * Test to see if we can get a full estimation without error
////	 * 
////	 * @throws Exception
////	 */
////	
////	@Test
////	public void testBeamFullEstimation() throws Exception {
////		PowerMockito.mockStatic(LuaRegistry.class);
////		try {
////			PowerMockito.whenNew(LuaRegistry.class).withAnyArguments().thenReturn(null);
////		} catch (Exception e) {
////			
////			e.printStackTrace();
////		}
////
////		// #1 -- run setup estimation
////		PowerMockito.mockStatic(LogFactory.class);
////		setUpEstimation(EstBeamTest.class, "beamFullEstimationTest", DeckMaterialListTypeTestImpl.Beam);
////		
////		// #2 -- test the estimation
////		Assert.assertTrue(isBeamEstimated);
////	}
////	
////	@Estimate(estimationProfileId = "beam")
////	public static void beamFullEstimationTest(String profileId) {
////		
////		isBeamEstimated = false;
////		
////		DeckEstimationProfile profile = (DeckEstimationProfile) EstimationProfile.getProfiles().get(profileId);
////		
////		DeckModelDTO deckModel = profile.getModel();
////		deckModel.setEstimationMethods(EstimationMethod.Full); 		// <------------------
////		profile.setModel(deckModel);
////		
////		// prepare levels
////		List<Level> levels = new ArrayList<Level>();
////		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
////		levels.add(level);
////		deckModel.setLevels(levels);
////		
////		// set products as needed
////		// The following ProductDTO are needed to just satisfy the estimate method, nothing more
////		
////		ProductDTO beam = ProductDTOMock.getProductDTOMock();
////		List<ProductDTO> beams = new ArrayList<ProductDTO>();
////		beams.add(beam);
////		deckModel.getProductMap().put(ProductType.BEAM, beams);
////		
////		// beams needs some joists
////		ProductDTO joist = ProductDTOMock.getProductDTOMock();
////		joist.setWidth(7.5);
////		List<ProductDTO> joists = new ArrayList<ProductDTO>();
////		joists.add(joist);
////		deckModel.getProductMap().put(ProductType.JOIST, joists);
////		
////		// beams needs some deckBoards
////		ProductDTO deckBoard = ProductDTOMock.getProductDTOMock();
////		deckBoard.setHeight(1.125);
////		List<ProductDTO> deckBoards = new ArrayList<ProductDTO>();
////		deckBoards.add(deckBoard);
////		deckModel.getProductMap().put(ProductType.DECK_BOARD, deckBoards);
////		
////		try{
////			EstBeam.estimateBeam("beam");
////			isBeamEstimated = true;
////		}catch(Exception e){
////			isBeamEstimated = false;
////			e.printStackTrace();
////		}
////	}
//
//	/**
//	 * Test so that beams are not added
//	 * @throws Exception
//	 */
//	@Test
//	public void testAddBoards() throws Exception{
//		
//		/** #### Accessing Private Fields ####*/
//		// to access private variable in class, the variable must be global in the class
//		int newNum = Whitebox.getInternalState(estSpindle, "num");
//		
//		//set internal private field
//		Whitebox.setInternalState(estSpy, "seamTrimQty", 2);
//		
//		//--------------------------------------------------------------------------------//
//		
//		// setup the environment
//		
//		/**
//		 * You can mock the profile only if you don't need to 
//		 * set/decorate any attributes to it
//		 * Because with mock objects, you can't set/change data on mock objects
//		 * mock objects are simple just used to bypass function calls and parameters
//		 */
//		DeckEstimationProfile profile = Mockito.mock(DeckEstimationProfile.class);
//		
//		/**
//		 * Here we do not mock the model because we will be setting/changing
//		 * data attributes to it
//		 */
//		DeckModelDTO deckModel = new DeckModelDTO();
//
//		/**
//		 * Injecting Mock Objects 
//		 * Again we do not Mockito.mock() beam because we need it to hold values
//		 * for the purpose of the method we are testing
//		 */
//		ProductDTO beam = ProductDTOMock.getProductDTOMock();
//		List<ProductDTO> beams = new ArrayList<ProductDTO>();
//		beams.add(beam);
//		
//		// add beams to beamProducts map
//		Map<ProductType, List<ProductDTO>> beamProducts = new HashMap<ProductType, List<ProductDTO>>();
//		beamProducts.put(ProductType.BEAM, beams);
//		
////		System.out.println(beamProducts.containsKey(ProductType.BEAM) + " -- beamProducts has beam map");	//##
//		
//		// beamProducts to deck
//		deckModel.setProducts(beamProducts);
//		
////		System.out.println( deckModel.getProductMap().containsKey(ProductType.BEAM) + " -- in deck" );	//##
//		
//		// mockito
//		Mockito.when(profile.getModel()).thenReturn(deckModel);
//		//Mockito.when(deckModel.getProducts( ProductType.BEAM )).thenReturn(beams);
//		
//		// you cannot call multiple methods chains like this in mockito
//		//Mockito.when(profile.getModel().getProducts( ProductType.BEAM )).thenReturn(beamProducts);
//		
//		Map<Double, Integer> results = new HashMap<Double, Integer>();
//		/**
//		 * These values below were set specifically to satisfy the method
//		 * we are testing
//		 * @see com.menard.deck.estimate.EstBeam#addBoards(DeckEstimationProfile profile, Map<Double, Integer> results, WhereUsed whereUsed)
//		 * 
//		 */
//		results.put(2.0001, 2);
//		results.put(2.0002, 4);
//		results.put(2.0003, 6);
//		
//		/*
//		 * 2.0 + 4.0 + 6.0 = 12.0
//		 * 12.0 should be the result
//		 */
//		
//		
//		// itemMap needed as method puts the qty inside map
//		Map<WhereUsed, ConcurrentHashMap<Long, Double>> itemMap = new HashMap<WhereUsed, ConcurrentHashMap<Long, Double>>();
//		Mockito.when(profile.getItemMap()).thenReturn(itemMap);
//		
//		ConcurrentSkipListSet<Long> csls = new ConcurrentSkipListSet<Long>();
//		Mockito.when(profile.getItemIds()).thenReturn(csls);
//		
//		// run test
//		EstBeam estBeam = Mockito.mock(EstBeam.class);
//		Whitebox.invokeMethod(estBeam,  "addBoards", profile, results, WhereUsed.BEAM_TO_BEAM);
//		
////		System.out.println( deckModel.getProductMap().containsKey(ProductType.BEAM) );
//		
//		// after test get the list back to test result
//		List<ProductDTO> newBeams = deckModel.getProductMap().get(ProductType.BEAM);
//		System.out.println( newBeams.get(0).getLength() );
//		System.out.println( itemMap.get(WhereUsed.BEAM_TO_BEAM).get(1L) );
//		Assert.assertTrue( itemMap.get(WhereUsed.BEAM_TO_BEAM).get(1L) == 12.0 );
//		
//		//********** Mocking ENums *********** //
//		// You don't mock enums because they are public, if you do, just make sure to get a correct
//		// return value of that enum
//		
//		
//		/** -------------------   Mocking Inside Private Methods (Non-Static) -----------------------------  **/
//		PowerMockito.stub(PowerMockito.method(TestingClass.class, "privateMethod", Param1.class, Param2.class)).toReturn(MockObject);;
//		
//		//************ Mocking static methods, meaning skip them****************************//
//		
//		//mock when outside class private static method is called (can only do one time mock however)
//		// this will mock and ignore all static method calls of this class
//		// PrepareForTest() ....make sure to put class in there
//		PowerMockito.stub(PowerMockito.method(OutSideClass.class, "getNumberOfBottomRails")).toReturn(100);
//		
//		/** return when inside class private static method calls */
//		
//		//mock return when inside class private static method is called
//		//NOTE: This will actually run the real method meaning it'll go inside the method
//		// if you do not want to go inside, use PowerMockito.mockStatic(ClassYouAreTesting.class) in combination with this below
//		// PrepareForTest() ....make sure to put class in there
//		PowerMockito.stub(PowerMockito.method(ClassYouAreTesting.class, "handrailIsWood")).toReturn(true);
//		
//		/** return when outside class public static method calls */
//		
//		// Mock when the outside class static method is called two or more in chain, bypassing the method call
//		/** MAKE SURE TO INCLUDE CLASS IN @prepareForTest() */
//		PowerMockito.mockStatic(RailingUtils.class);
//		// when a mock public static method is called two or more in chains
//		// using matching, you have to use match for all parameters, can't just  do one match
//		PowerMockito.when(RailingUtils.getNumberOfBottomRails(Mockito.anyListOf(Level.class))).thenReturn(100, 300);
//		//OR
//		PowerMockito.when(SearchBO.findByCategory(Mockito.anyLong(),
//				Mockito.anyInt(), Mockito.anyInt(), Mockito.anyListOf(String.class))).thenReturn(searchResult);
//
//		/** no returns & bypass all outside class public static method calls **/
//		
//		// this will mock and ignore all static method calls of this class, all returns will be null or zero
//		PowerMockito.mockStatic(RailingEstimationBA.class);			// OR
//		PowerMockito.doNothing().when(RailingEstimationBA.class);
//		
//		/** return inside class public method calls */
//		
//		PowerMockito.when(profile.getModel()).thenReturn(deckModel);
//		
//		
//		// ex: http://www.gitshah.com/2010/05/how-to-partially-mock-class-and-its.html
//		/*******************************************************************************************/
//		/**###############  Verify outside public static method was reach ######################## */
//		/**_______________________________________________________________________________________ */
//		// @PrepareForTest({ItemContainerBA.class}) <--- put in there too
//		PowerMockito.mockStatic(ItemContainerBA.class);
//		
//		//test the private static method
//		Whitebox.invokeMethod(estWoodRail, "estimateWoodBottomRailFasteners", profile, 100);
//		
//		/** verify outside class public static */
//		//Verify outside class public static method was reached
//		PowerMockito.verifyStatic(Mockito.times(1));
//		// combine top code with bottom code, it pairs
//		ItemContainerBA.methodA(Mockito.any(ClassA.class), 
//			Mockito.anyLong(), 
//			Mockito.anyDouble(),
//			Mockito.any(WhereUsed.class));
//		
//		/** Verify 2nd outside class public static method, have to do a separate verif for each public static method */
//		PowerMockito.verifyStatic(Mockito.times(2));
//		// combine top code with bottom code, it pairs
//		ItemContainerBA.methodB(Mockito.any(ClassB.class), 
//			Mockito.anyLong());
//		//------------------------------------------------------------------------------------------ //
//		
//		// ex: http://java.dzone.com/articles/why-use-powermock-mock-private
//		/**################   Verify & bypass inside class private static method calls, but DON't RUN it ################ */
//		PowerMockito.mockStatic(EstWoodRail.class, Mockito.CALLS_REAL_METHODS);
//		PowerMockito.suppress(PowerMockito.method(EstWoodRail.class, "estimateWoodBottomRailFasteners"));	//don't run this method
//		
//		//set up spy if needed
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
//		//----------------------------------------------------------------------------------------------//
//		
//		/** ########################  Catching argument or value when a method is called */
//		
//		
//		//prepare to verify a outside class public static method inside testing method
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
//		ClassA.methodA(argument.capture());
//		
//		//test
//		Assert.assertEquals(1.0, argument.getValue());
//		//----------------------------------------------------------------------------------//
//		
//		
//	}
//
//}