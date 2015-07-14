package com.xai.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@CustomAnnotationComplex(author="tom", date="01-01-11", age=5, reviewers={"Ali","Bob"})
public class AnnotationDemo {

	//you can create nested annotation like this
	/*
	@Documented
	@Retention( RetentionPolicy.RUNTIME )	//can be analyzed at runtime using reflection
	@Target( ElementType.PACKAGE )				//applied to any class element
	@interface AuthorMeta{		//@interface nameOfAnnotation
		String author();		//the parameter for the annotation
		String date();
		int age() default 1;
		String[] reviewers();
	}
	*/
	
	@CustomAnnotationMethod(info="some dumb method")
	public void doSomething(){
		
	}
	
	public static void main(String [] args){
		
		//how to get the annotations on this AnnotationDemo class
		Class<AnnotationDemo> obj = AnnotationDemo.class;
		//retrieve all annotations from the class
		Annotation[] annotations = obj.getAnnotations();
		for(Annotation annotation : annotations){
			System.out.println( annotation );
		}
		
		//check if there is any annotation in the class
		// Checks if an annotation is present, if so get it
		if( obj.isAnnotationPresent( CustomAnnotationComplex.class ) )
		{
			// Gets the desired annotation
			Annotation annotation = obj.getAnnotation( CustomAnnotationComplex.class );
			System.out.println( annotation );
		}
		
		//check if all methods have the annotation
		for(Method method: obj.getDeclaredMethods()){
			if(method.isAnnotationPresent(CustomAnnotationMethod.class)){
				Annotation annotation = method.getAnnotation(CustomAnnotationMethod.class);
				System.out.println(annotation);
			
			}
		}
		
	}
	
}
