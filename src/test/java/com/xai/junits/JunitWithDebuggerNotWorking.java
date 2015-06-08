//package com.xai.junits;
//
//// When you want the debugger to work for testing purposes
//// comment out the @Rule public PowerMockRule
//// comment out extends DeckTestImpl
//// uncomment @RunWith(PowerMockRunner.class)
//
//// when you're ready to revert and don't need the break points in debugger to work
//// uncomment @Rule public PowerMockRule
//// uncomment extends DeckTestImpl
//// comment @RunWith(PowerMockRunner.class)
//// uncomment @Rule
//// 
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentSkipListSet;
//
//import junit.framework.Assert;
//
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
//import com.menard.DeckCategoryId;
//import com.menard.deck.DeckTestImpl;
//import com.menard.deck.itemContainer.ba.ItemContainerBA;
//import com.menard.deck.materialList.WhereUsed;
//import com.menard.deck.model.dto.DeckModelDTO;
//import com.menard.deck.profile.DeckEstimationProfile;
//import com.menard.deck.railing.RailingCategoryInfo;
//import com.menard.deck.railing.RailingCategoryInfoMock;
//import com.menard.deck.selectable.ProductType;
//import com.menard.deck.shape.Level;
//import com.menard.deck.shape.LevelMock;
//import com.menard.reaf.estimate.Estimate;
//import com.menard.reaf.estimate.EstimateManager;
//import com.menard.reaf.estimate.EstimationProfile;
//import com.menard.reaf.resourceManager.mcom.SearchBO;
//import com.menard.reaf.resourceManager.mcom.dto.ProductDTO;
//import com.menard.reaf.resourceManager.mcom.dto.ProductDTOMock;
//import com.menard.reaf.script.LuaRegistry;
//import com.menard.reafUtils.logging.LogFactory;
//import com.menards.menardswebservices.dto.ItemPropertiesDTO;
//import com.menards.menardswebservices.dto.SearchResultDTO;
//
//// my custom class: SearchBO.class
//@PrepareForTest({LuaRegistry.class, EstimateManager.class, EstSpindle.class}) //, SearchBO.class})
////@RunWith(PowerMockRunner.class)
//public class JunitWithDebuggerNotWorking extends DeckTestImpl {
////	
////	private static boolean canEstimateSpindle = false;
////	private static boolean isSpindleEstimated = false;
////	
//	@Rule
//	public PowerMockRule rule = new PowerMockRule();
////	
////	/**
////	 * Test so we CAN run EstSpindle.canEstimate()
////	 * 
////	 * @throws Exception
////	 */
////	
////	@Test
////	public void testCanEstimate() throws Exception{
////		PowerMockito.mockStatic(LuaRegistry.class);
////		try {
////			PowerMockito.whenNew(LuaRegistry.class).withAnyArguments().thenReturn(null);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		// #1 -- run setup estimation
////		PowerMockito.mockStatic(LogFactory.class);
////		setUpEstimation(EstSpindleTest.class, "canEstimateTest", DeckMaterialListTypeTestImpl.Spindle);
////
////		// #2 -- test the results
////		Assert.assertTrue("Should be able to estimate", canEstimateSpindle);
////
////	}
////	
////	@Estimate(estimationProfileId = "spindle")
////	public static void canEstimateTest(String profileId){
////
////		//The following setup will allow spindles to be estimated with proper railings
////		
////		///////////////////////////////////////////////////////
////		// Create the necessary mock environment to run test //
////		///////////////////////////////////////////////////////
////		
////		canEstimateSpindle = false;
////		
////		// get deck model from profile
////		DeckEstimationProfile profile = (DeckEstimationProfile) EstimationProfile.getProfiles().get(profileId);
////		DeckModelDTO deckModel = profile.getModel();
////		
////		//create mock level(s) as needed
////		List<Level> levels = new ArrayList<Level>();
////		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
////		levels.add(level);
////		deckModel.setLevels(levels);
////		
////		//create, populate and set ProductDTO product(s) as needed
////		ProductDTO spindle = ProductDTOMock.getProductDTOMock();
////		List<ProductDTO> spindles = new ArrayList<ProductDTO>();
////		spindles.add(spindle);
////		deckModel.getProductMap().put(ProductType.SPINDLE, spindles);
////		
////		//////////////////////////////////////////////////////////////////
////		// declare needed attributes to satisfy the logic requirements	//
////		//////////////////////////////////////////////////////////////////
////		
////		deckModel.setHasRailing(true);
////		deckModel.setRailingType("ac2");	//as long as not set to fusion
////		
////		// run & test estimate
////		canEstimateSpindle = EstSpindle.canEstimate(profileId);
////		
////	}
////	
////	/**
////	 * Test so we CANNOT estimate spindles if deck has a railing kit
////	 * 
////	 */
////	
////	@Test
////	public void testCanNotEstimateSpindleWithRailingKit() throws Exception{
////		PowerMockito.mockStatic(LuaRegistry.class);
////		try{
////			PowerMockito.whenNew(LuaRegistry.class).withAnyArguments().thenReturn(null);
////		}catch(Exception e){
////			e.printStackTrace();
////		}
////
////		// #1 -- run setup estimation
////		PowerMockito.mockStatic(LogFactory.class);
////		setUpEstimation(EstSpindleTest.class, "canNotEstimateSpindleWithRailingKitTest", DeckMaterialListTypeTestImpl.Spindle);
////
////		// #2 -- test the results
////		Assert.assertTrue("Should not be able to estimate", !canEstimateSpindle);
////
////	}
////		
////	@Estimate(estimationProfileId = "spindle")
////	public static void canNotEstimateSpindleWithRailingKitTest(String profileId) {
////		
////		///////////////////////////////////////////////////////
////		// Create the necessary mock environment to run test //
////		///////////////////////////////////////////////////////
////		
////		canEstimateSpindle = false;
////		
////		//The following setup will trigger a deck model to have a railing kit
////		
////		// get deck model from profile
////		DeckEstimationProfile profile = (DeckEstimationProfile) EstimationProfile.getProfiles().get(profileId);
////		DeckModelDTO deckModel = profile.getModel();
////		
////		//create mock level(s) as needed
////		List<Level> levels = new ArrayList<Level>();
////		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
////		levels.add(level);
////		deckModel.setLevels(levels);
////		
////		//create, populate and set ProductDTO product(s) as needed
////		ProductDTO spindle = ProductDTOMock.getProductDTOMock();
////		List<ProductDTO> spindles = new ArrayList<ProductDTO>();
////		spindles.add(spindle);
////		deckModel.getProductMap().put(ProductType.SPINDLE, spindles);
////		
////		//create a railing kit to prevent spindles from estimating
////		ProductDTO railingKit = ProductDTOMock.getProductDTOMock();
////		List<ProductDTO> railingKits = new ArrayList<ProductDTO>();
////		railingKits.add(railingKit);
////		deckModel.getProductMap().put(ProductType.RAILING_KIT, railingKits);
////		
////		//////////////////////////////////////////////////////////////////
////		// declare needed attributes to satisfy the logic requirements	//
////		//////////////////////////////////////////////////////////////////
////		
////		deckModel.setHasRailing(true);
////		deckModel.setRailingType("ac2");
////		
////		// run the test
////		canEstimateSpindle = EstSpindle.canEstimate("spindle");
////	}
////	
////	/**
////	 * Test so we CANNOT estimate spindles if Fusion Railing Kit is used
////	 * 
////	 * @throws Exception
////	 */
////	
////	@Test
////	public void testCanNotEstimateSpindleWithFusionRailingKitUsed() throws Exception{
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
////		setUpEstimation(EstSpindleTest.class, "canNotEstimateSpindleWithFusionRailingKitUsedTest", DeckMaterialListTypeTestImpl.Spindle);
////
////		// #2 -- test the results
////		Assert.assertTrue("Should not be able to estimate", !canEstimateSpindle);
////
////	}
////	
////	@Estimate(estimationProfileId = "spindle")
////	public static void canNotEstimateSpindleWithFusionRailingKitUsedTest(String profileId) {
////		
////		///////////////////////////////////////////////////////
////		// Create the necessary mock environment to run test //
////		///////////////////////////////////////////////////////
////		
////		canEstimateSpindle = false;
////		
////		//The following setup will trigger Fusion Railing Kit to be used
////		
////		// get deck model from profile
////		DeckEstimationProfile profile = (DeckEstimationProfile) EstimationProfile.getProfiles().get(profileId);
////		DeckModelDTO deckModel = profile.getModel();
////		
////		//create mock level(s) as needed
////		List<Level> levels = new ArrayList<Level>();
////		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
////		levels.add(level);
////		deckModel.setLevels(levels);
////		
////		//create, populate and set ProductDTO product(s) as needed
////		ProductDTO spindle = ProductDTOMock.getProductDTOMock();
////		spindle.setColor("White");
////		
////		//create, add, set specific spindle property
////		ItemPropertiesDTO property = new ItemPropertiesDTO();
////		property.setPropname("Spec_Material Type");
////		property.setPropvalue("composite");
////		
////		// put property into list
////		List<ItemPropertiesDTO> properties = new ArrayList<ItemPropertiesDTO>();
////		properties.add(property);
////		spindle.setProperties(properties);
////		
////		// add mock spindle to model
////		List<ProductDTO> spindles = new ArrayList<ProductDTO>();
////		spindles.add(spindle);
////		deckModel.getProductMap().put(ProductType.SPINDLE, spindles);
////		
////		//create a white composite_hand_rail
////		ProductDTO compositeHandRail = ProductDTOMock.getProductDTOMock();
////		compositeHandRail.setColor("White");
////		List<ProductDTO> compositeHandRails = new ArrayList<ProductDTO>();
////		compositeHandRails.add(compositeHandRail);
////		deckModel.getProductMap().put(ProductType.COMPOSITE_HAND_RAIL, compositeHandRails);
////		
////		//////////////////////////////////////////////////////////////////
////		// declare needed attributes to satisfy the logic requirements	//
////		//////////////////////////////////////////////////////////////////
////		
////		deckModel.setHasRailing(true);
////		deckModel.setRailingType("fusion");
////		
////		// run the test
////		canEstimateSpindle = EstSpindle.canEstimate("spindle");
////	}
////	
////	/**
////	 * Test a small portion of the estimateSpindle() method
////	 * 
////	 * @throws Exception
////	 */
////	
////	@Test
////	public void testAddSpindles() throws Exception{
////		PowerMockito.mockStatic(LuaRegistry.class);
////		try {
////			PowerMockito.whenNew(LuaRegistry.class).withAnyArguments().thenReturn(null);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		// #1 -- run setup estimation
////		PowerMockito.mockStatic(LogFactory.class);
////		setUpEstimation(EstSpindleTest.class, "addSpindlesTest", DeckMaterialListTypeTestImpl.Spindle);
////
////		// #2 -- test the results
////		Assert.assertTrue("true", canEstimateSpindle);
////		Assert.assertTrue("true", isSpindleEstimated);
////		
////	}
////	
////	@Estimate(estimationProfileId = "spindle")
////	public static void addSpindlesTest(String profileId) {
////		
////		///////////////////////////////////////////////////////
////		// Create the necessary mock environment to run test //
////		///////////////////////////////////////////////////////
////		canEstimateSpindle = false;
////		isSpindleEstimated= false;
////		
////		//The following setup should allow estimateSpindle() to run successfully and add spindles
////		
////		// get deck model from profile
////		DeckEstimationProfile profile = (DeckEstimationProfile) EstimationProfile.getProfiles().get(profileId);
////		DeckModelDTO deckModel = profile.getModel();
////		
////		//create mock level(s) as needed
////		List<Level> levels = new ArrayList<Level>();
////		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
////		levels.add(level);
////		deckModel.setLevels(levels);
////		
////		//create and set ProductDTO product(s) as needed
////		ProductDTO spindle = ProductDTOMock.getProductDTOMock();			// populate mock products
////		List<ProductDTO> spindles = new ArrayList<ProductDTO>();
////		spindles.add(spindle);
////		deckModel.getProductMap().put(ProductType.SPINDLE, spindles);
////		
////		//create and set railingCategoryInfo - category needs to be added this way onto railingCategory
////		RailingCategoryInfo railingCategoryInfo = RailingCategoryInfoMock.getRailingCategoryInfo_36inch_Rustic_Square_Spindles();
////		deckModel.setRailingCategoryInfo(railingCategoryInfo);
////		
////		//////////////////////////////////////////////////////////////////
////		// declare needed attributes to satisfy the logic requirements	//
////		//////////////////////////////////////////////////////////////////
////		
////		deckModel.setHasRailing(true);
////		//from RailingType.RUSTIC
////		deckModel.setRailingType("rustic");
////		
////		
////		//ItemSelectDTO compositeSpindleFastener = Mockito.mock(ItemSelectDTO.class);
////		//Mockito.when(compositeSpindleFastener.getProperty(ReafProperties.SOLR_SPEC_WASTE_FACTOR)).thenReturn("kittens");		
////
////		
////		// run the test
////		canEstimateSpindle = EstSpindle.canEstimate("spindle");
////		
////		/*
////		// PowerMocito - Mock necessary static methods within the method we are testing
////		PowerMockito.mockStatic(SearchBO.class);
////		
////		// needed variables to satisfy static method
////		ArrayList<String> fqAdditionalList = new ArrayList<String>();
////		SearchResultDTO sr = new SearchResultDTO();
////		
////		// NEED TO FIND OUT WHAT TO RETURN HERE
////		PowerMockito.when(SearchBO.findByCategory(DeckCategoryId.FASTENER_CATEGORY_ID, 0, 100, fqAdditionalList)).thenReturn(null);
////		*/
////		
////		try{
////			EstSpindle.estimateSpindle(profileId);
////			isSpindleEstimated = true;
////		}catch(Exception e){
////			e.printStackTrace();
////		}
////		
////	}
////	
////	/**
////	 * Test so we CANNOT estimate fastener spindles if we have spindle spacers
////	 */
////	
////	//@Test
////	public void testNoFasternersForSpindlesIfDeckModelHasSpindleSpacer() {
////		
////		///////////////////////////////////////////////////////
////		// Create the necessary mock environment to run test //
////		///////////////////////////////////////////////////////
////		
////		// create profile
////		DeckEstimationProfile profile = new DeckEstimationProfile("spindle", DeckMaterialListTypeTestImpl.Spindle);
////		DeckModelDTO deckModel = profile.getModel();
////		
////		// create and set ProductDTO product(s) as needed -- add product spindle spacer
////		ProductDTO spindleSpacer = ProductDTOMock.getProductDTOMock();
////		List<ProductDTO> spindleSpacers = new ArrayList<ProductDTO>();
////		spindleSpacers.add(spindleSpacer);
////		deckModel.getProductMap().put(ProductType.SPINDLE_SPACER, spindleSpacers);
////		
////		
////		//create and set railingCategoryInfo
////		RailingCategoryInfo railingCategoryInfo = RailingCategoryInfoMock.getRailingCategoryInfo_AC2_36inch_Shaped_Horizontal_Handrail();
////		deckModel.setRailingCategoryInfo(railingCategoryInfo);
////		
////		//////////////////////////////////////////////////////////////////
////		// declare needed attributes to satisfy the logic requirements	//
////		//////////////////////////////////////////////////////////////////
////		
////		deckModel.setHasRailing(true);
////		deckModel.setRailingType("rustic");
////		
////		// test method
////		try{
////			EstSpindle.estimateSpindle("spindle");
////		}catch(Exception e){
////			e.printStackTrace();
////		}
////		
////		// fasteners should not get added to deck board due to having spindle spacer
////		/*
////		if( profile.getModel().hasProducts(ProductType.DECK_BOARD_FASTENER) ){
////			Assert.fail();
////		}
////		*/
////		 
////	}
////	
//	@Test
//	public void testEx() throws Exception{
//		
//		//DeckEstimationProfile profile = new DeckEstimationProfile("spindle", DeckMaterialListTypeTestImpl.Spindle);
//	
//		DeckEstimationProfile profile = Mockito.mock(DeckEstimationProfile.class);
//		ProductDTO spindle = Mockito.mock(ProductDTO.class);
//		EstSpindle estSpindle = Mockito.mock(EstSpindle.class);
//		DeckModelDTO deckModel = Mockito.mock(DeckModelDTO.class);
//		RailingCategoryInfo railingCategoryInfo = Mockito.mock(RailingCategoryInfo.class);
//		
//		profile.setModel(deckModel);
//		
//		// to access private variable in class, the variable must be global in the class
//		//int newNum = Whitebox.getInternalState(estSpindle, "num");
//		Mockito.when(profile.getModel()).thenReturn(deckModel);
//		
//		Mockito.when(railingCategoryInfo.getSpindleHeight()).thenReturn(0.0);
//		Mockito.when(deckModel.getRailingCategoryInfo()).thenReturn(railingCategoryInfo);
//		
//		Mockito.when(spindle.getProperty(Mockito.anyString())).thenReturn("10.0", "1.0");
//		Mockito.when(spindle.getItemid()).thenReturn(1L);
//		
//		//itemMap
//		//Map itemMap = Mockito.mock(Map.class);
//		Map<WhereUsed, ConcurrentHashMap<Long, Double>> itemMap = 
//				new HashMap<WhereUsed, ConcurrentHashMap<Long, Double>>();
//		Mockito.when(profile.getItemMap()).thenReturn(itemMap);
//		
//		//Mockito.when(itemMap.containsKey(Mockito.anyString())).thenReturn(false);
//		
//		//ConcurrentSkipListSet<Long> csls = Mockito.mock(ConcurrentSkipListSet.class);
//		ConcurrentSkipListSet<Long> csls = new ConcurrentSkipListSet<Long>();
//		Mockito.when(profile.getItemIds()).thenReturn(csls);
//
//		// this is how you hack and test a private method
//		/**
//		 * @addSpindle use Mockito.mock() to mock the class first above
//		 * @param estSpindle use @PrepareForTest({EstSpindle.class}) in order to hack the class's private method
//		 * profile, spindle, 20, WhereUsed.SPINDLE --> are the private method's param
//		 */
//		Whitebox.invokeMethod(estSpindle, "addSpindle", profile, spindle, 20, WhereUsed.SPINDLE);
//		
//		// test results
//		Assert.assertEquals( 2.0, itemMap.get(WhereUsed.SPINDLE).get(0L));
//		
//	}
//	
//	
//}
