package com.xai.annotation.inheritance;

/**
 * Inheriting annotations does not work for interfaces, methods, etc, 
 * it only works for extending sub classes
 * not classes that implement interfaces
 *
 */
public class AnnotationInheritanceDemo {
	
	//proves that both super and sub clases have the annotation for extending classes
	//both the super and sub class will have the annotation present
	public static void main(String [] args){
		
		System.out.println( "is true: " 
		+ AnnotationSuperClass.class.isAnnotationPresent( InheritedAnnotation.class ) );
        
		System.out.println( "is true: " 
		+ AnnotationSubClass.class.isAnnotationPresent( InheritedAnnotation.class ) );
		
	}
	
}
