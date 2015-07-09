package com.xai.patterns.mvc2.view;

import com.xai.patterns.mvc2.domain.Student;

public class StudentView {

	public void update(Student student){
		System.out.println("Student name is: "+ student.getName());
	}
}
