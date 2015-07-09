package com.xai.patterns.mvc2.controller;

import com.xai.patterns.mvc2.domain.Student;
import com.xai.patterns.mvc2.view.StudentView;

public class StudentController {

	Student student;
	StudentView view;
	
	public StudentController(Student student, StudentView view){
		this.student = student;
		this.view = view;
	}
	
	public void updateName(Student student, String name){
		student.setName(name);
	}
	
	public void updateView(){
		view.update(student);
	}
	
}
