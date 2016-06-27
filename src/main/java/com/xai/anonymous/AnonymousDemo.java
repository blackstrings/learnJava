package com.xai.anonymous;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.AnnotationMethodDeclaration;

public class AnonymousDemo {

	public static void main(String[] args){
		
		//how to create an anonymous method at instantiation
		Object obj = new Object(){
			public void jump(){
				System.out.println("jump");
			}
		};
		//obj.jump() //error because the class Object is not a custom class with method jump()
		
		//how to add an anonymous initializer
		Object obj2 = new Object(){
			{
				System.out.println("i'm alive");
			}
		};
		
		//if you created a class, you can override with anonymous methods like this
		SomeClass c = new SomeClass(){
			public void someMethod(){
				System.out.println("ovveride method of some class");
			}
		};
		
		SomeClass c2 = new SomeClass(){
			public void anonMethod(){
				System.out.println("annonmous method");
			}
		};
		
		c.someMethod();
		
	}
}
