package com.xai.annotation.inheritance;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited								//all sub class will have this, but only when extending not implement
@Retention( RetentionPolicy.RUNTIME )	//can be analyzed at runtime using reflection
@Target( ElementType.TYPE )				//applied to any class element
public @interface InheritedAnnotation {
	String info();
}
