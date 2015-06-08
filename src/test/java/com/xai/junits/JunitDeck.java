//package com.xai.junits;
//
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.rule.PowerMockRule;
//import org.powermock.reflect.Whitebox;	// to use whitebox to invoke private method or to set internal class variables
//
//@PrepareForTest({TestClassA.class, TestClassB.class})
//@RunWith(PowerMockRunner.class)
//public class JunitDeck extends DeckTestImpl {
//	//you should extend DeckTestImpl to get the selectionsList to work
//	
//	//the before setup helps reset and init selections
//	@Before
//	public void before() {
//		//DeckShapeCursor is used to test with the use of ShapeCursor.getInstance()
//		DeckShapeCursor.getInstance().init();
//		SelectionsList.checkout();
//		DeckSelectionsList.getInstance().reset();
//		SelectionsList.commit();
//		DeckShapeCursor.getInstance().reset();
//		DeckShapeCursor.selectNone();
//	}
//	
//	@Test
//	public void willNewRampCollideTest(){
//		//you can choose to create a list to hold levels if want
//		List<Level> levels = new ArrayList<Level>();
//		Level level = LevelMock.getLevelWithBeams_RampBottomSide();
//		
//		//add level to list
//		levels.add(level);
//		
//		//set or mimick a mouse cursor selecting segments on a level in Deck
//		// short version
//		level.getSpline().getSplineIter().setCurrent(level.getSegmentList().get(0));
//		//long version
//		MSpline spline = level.getSpline();
//		MSplineIterator splineItr = spline.getSplineIter();
//		splineItr.setCurrent(level.getSegmentList().get(0));
//		//the idea is to set the selection on the Iterator, so spline iterator for segments, level iterator for levels
//		
//		//get the current selection on a level
//		level.getCurrent(); // the items inside level must first be selected
//		
//		//add level(s) to the selections list
//		//must check out first
//		DeckSelectionsList.checkout();
//		DeckSelectionsList.getInstance().getLevels().add(level);
//		//call RampBA or any BA then close the selectionsList
//		DeckSelectionsList.commit();
//		
//		//get level
//		DeckSelectionsList.getInstance().getLevels().getCurrent(); // there more ways to get a level than this
//	}
//	
//	/*
//	 * willNewRampCollide()
//	 * test 1 - test for false
//	 * when new ramp is created, it WILL collide with other parts of the same level
//	 *
//	 */
//	@Test
//	public void willNewRampCollideTestCollide(){
//		
//		//Level level = LevelMock.getLevelWithBeams_RampBottomSide();
//		
//		//how to custom create a level
//		LinkedList<MControlPoint> cps = new LinkedList<MControlPoint>();
//		cps.add(new MControlPoint(99904.0, 100072.0));
//		cps.add(new MControlPoint(99904.0, 99928.0));
//		cps.add(new MControlPoint(100096.0, 99928.0));
//		cps.add(new MControlPoint(100096.0, 100072.0));
//		cps.add(new MControlPoint(100021.0, 100072.0));
//		cps.add(new MControlPoint(100021.0, 100024.0));
//		cps.add(new MControlPoint(99955.0, 100024.0));
//		cps.add(new MControlPoint(99955.0, 100072.0));
//		Level level = new Level(cps, 0);
//		level.setHeight(12.0);
//		level.setLabel("level1");
//		
//		//not needed but can
//		List<Level> levels = new ArrayList<Level>();
//		levels.add(level);
//		
//		
//		/* above coordinates resembles shape below
//		 * level measurements
//		 * 
//			 				16'
//			/////////////////////////////////
//			/////////////////////////////////
//			/////////////////////////////////
//			/////////////////////////////////
//		12'	/////////////////////////////////
//			/////////////////////////////////
//			////////	4'6"	/////////////
//			////////			/////////////
//			////////4'			/////////////
//			////////			/////////////
//			////////			/////////////
//
//
//		* level spline indexes
//		
//			 		       1
//			/////////////////////////////////
//			/////////////////////////////////
//			/////////////////////////////////
//			/////////////////////////////////
//	   0	/////////////////////////////////
//			///////////////////////////////// 2
//			////////	 5		/////////////
//			////////			/////////////
//			//////// 6		  4	/////////////
//			////////			/////////////
//			////////			/////////////
//				7					  3
//		
//		*/
//		
//		//select the 4th segment on level
//		level.getSpline().getSplineIter().setCurrent(level.getSegmentList().get(4));
//		//when we do level.getCurrent();
//		// the segment in setCurrent will be the one returned
//		
//		// checkout in order to modify selectionsList
//		SelectionsList.checkout();	
//		DeckSelectionsList.getInstance().getLevels().add(level);
//		
//		boolean result = RampBA.willNewRampCollide();
//		
//		SelectionsList.commit();
//		
//		//should be false
//		Assert.assertEquals(result, false);
//		
//	}
//	
//	/* functions i have to test in RampBATest.java - delete this when ready for commit
//	
//	- talk to dave, not sure how it works
//	•	doesRampCollideWithTopLevel
//	
//	- BD is not an instance of MSegment -- check why so
//	•	willNewRampCollide
//	
//	- why shapeCursor is not getting set
//	•	canRemove
//	
//	done but can test opposite
//	•	canIncreaseWidth(Ramp ramp)
//	done
//	•	canIncreaseWidth(double rampWidth)
//	done
//	•	modifyRampWidth(Ramp ramp, boolean increase)
//	
//	 - need to know what MSegment to pass in, code coverage not fully covered
//	•	increaseRampWidth(Ramp ramp, Level level, MSegment levelSegment, double amount)
//	•	removeSameLevelControlPoints(Level level, MSegment levelSegment)
//	•	decreaseRampWidth(Ramp ramp, Level level, MSegment levelSegment, double amount)
//	
//	done
//	•	increaseRampLength(Ramp ramp, double amount)
//	done
//	•	getSlopeMessage
//	done
//	•	changeRampHeight(Ramp ramp, double amount)
//
//	*/
//	
//}
