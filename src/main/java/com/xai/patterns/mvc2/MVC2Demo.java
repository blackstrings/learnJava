package com.xai.patterns.mvc2;

import com.xai.patterns.mvc2.controller.StudentController;
import com.xai.patterns.mvc2.domain.Student;
import com.xai.patterns.mvc2.view.StudentView;

//When you don't want the model to be coupled with its view.
//The model does not know anything about the view
public class MVC2Demo {

	public static void main(String [] args){
		Student student = new Student();
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(student, view);
		
		//here on, we should only be able to use the controller
		//to perform whatever changes to the model and view
		controller.updateName(student, "Tom");
		controller.updateView();
		
	}
}
