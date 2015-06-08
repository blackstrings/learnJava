package com.xai.timer;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * Link to document example 
 * http://www.yegor256.com/2014/06/01/aop-aspectj-java-method-logging.html
 * @author xlao
 *
 */

@Aspect
public class AspectLogger {
	
	private Logger logger = Logger.getLogger("Aspect");
	
	//@Around("execution(* com.xai.timer..*.*(..))") //-- an entire package
	
	/**
	 * When a defined package, class, or method gets intercepted, the method logTimeMethod
	 * will execute
	 * methods with around annotation will get executed first the actual method.
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	
	// * * = this Around says advice should be applied to public, protected, or private
	// its name (anyname)
	// its arguments (any arguments)
	// and it can be annotated with @Loggable 
	//@Around("execution(* *(..))")
	//@Around("execution(* com.xai.timer..*.*(..))") //-- an entire package
	//@Around("execution(* *.*(..)) && @annotation(Loggable)")
	
	//3 types of Advices (Before, After, Around)
	//Adivce syntax explanation
	//first * : don't care about return type
	//2nd * : don't care about package and class names
	//3rd * : don't care about method name
	// .. : don't care about method arguments
	@Around("execution(* *.*(..))")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//Because we are using @Around, we have to use a joinPoint to execute in the method
		//for @Before and @After advices, you don't have to use a joinPoint
		
		// 1. Stuff to do before the execution
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 2. run the execution
		//instance of class ProceedingJoinPoint is used
		//calling joinPoint.proceed() will call the original method it intercepts
		Object result = joinPoint.proceed();
		
		// 3. Stuff to do after the execution
		stopWatch.stop();
		
		//logging starts here
		//log class, method info to console
		logger.info("Time Exec: " + stopWatch.getTotalTimeSeconds() );
		//print to console
		System.out.println("aspect logged: Total Time: " + stopWatch.getTotalTimeSeconds());
		
		// 4. return the result
		return result;
		
	}
	
	/*
	@Pointcut("execution(* *.*(..))")
	void anyCallToMethod(){
		
	}
	*/
	
	/*
	@Before("anyCallToMethod()")
	public void beforeLogging(){
		System.out.println("Before Logging Methods");
	}
	*/
	
}
