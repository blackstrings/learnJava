package com.xai.annotation;

import java.lang.annotation.Documented;

//@repeatable is only avaialbe in java8+

@Documented		//to make java doc aware of these param
public @interface CustomAnnotation {
	String info();				//without the default, this param is required
	int counter() default 0;	//use default to enable omitting the 2nd param when needed
}
