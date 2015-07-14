package com.xai.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//more complex example of annotation

@Documented
//@Repeatable( RepeatedValues.class )	//only available in java 8
@Retention( RetentionPolicy.RUNTIME )	//can be analyzed at runtime using reflection
@Target( ElementType.TYPE )				//applied to any class element
public @interface CustomAnnotationComplex {
	String author();		//the parameter for the annotation
	String date();			//date
	int age() default 1;	// default so we can ommit this param
	String[] reviewers();	//string array
}

