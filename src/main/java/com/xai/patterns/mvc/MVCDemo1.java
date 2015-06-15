package com.xai.patterns.mvc;

import com.xai.patterns.mvc.controller.TVController;
import com.xai.patterns.mvc.model.TVModel;
import com.xai.patterns.mvc.view.TVView;

/**
 * the main application, you see how model, view, and controller comes together
 * @author xlao
 *
 */
public class MVCDemo1 {

	//the entrance of the main app starts here
	public static void main(String [] args){
		
		//create the model
		TVModel model = new TVModel("Sony");
		//crate the view
		TVView view = new TVView();
		
		//both view and model will be put into the controller
		TVController controller = new TVController(model, view);
		
		///from here on out, you only use the model's controller
		//which is TVController referenced by the name controller
		
		//example of what to not do
		//view.display(model);
			//wrong!! do not touch view or model anymore
		
		//use the controller instead beause the controller should have been
		//setup to do all the methods that the model needs to do
		controller.updateView();
	}
}
