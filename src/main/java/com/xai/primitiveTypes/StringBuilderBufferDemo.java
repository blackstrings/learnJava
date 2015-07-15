package com.xai.primitiveTypes;

import org.springframework.util.StopWatch;

/**
 * <p>
 * It is best to use StringBuffer or stringBuilder when 
 * concatenating strings for best performance.
 * String += "more string" uses more performance than StringBuffer
 * The key is to concat strings with StringBuffer/Builder 
 * then convert the final builder/buffer to string for final use
 * </p>
 * <p>
 * You will see that when doing many string concat, 
 * using the stringBuffer or stringBuilder
 * is a no brainer vs using just string += to concat
 * </p>
 * <p>
 * Use StringBuilder for single threaded environments or where synchronizing isn't needed.
 * User StringBuffer in multi-threads and where synchronizing is needed.
 * </p>
 */
public class StringBuilderBufferDemo {

	public static void main(String [] args){
		
		int loop = 5000;
		
		//STRING BUFFER
		StopWatch sw = new StopWatch();
		sw.start();
		StringBuffer log = new StringBuffer();
		for(int i=0; i<loop; i++){
			log.append(StringBuilderBufferDemo.class.getName());
			log.append(".");
			log.append(StringBuilderBufferDemo.class.getSimpleName());
			log.append("-");
			log.append(sw.getTotalTimeMillis());
		}
		sw.stop();
		System.out.println("StringBuffer: " + sw.getTotalTimeMillis() + "ms");
		
		//STRING BUILDER
		sw = new StopWatch();
		sw.start();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<loop; i++){
			sb.append(StringBuilderBufferDemo.class.getName());
			sb.append(".");
			sb.append(StringBuilderBufferDemo.class.getSimpleName());
			sb.append("-");
			sb.append(sw.getTotalTimeMillis());
		}
		sw.stop();
		System.out.println("StringBuilder: " + sw.getTotalTimeMillis() + "ms");
		
		//STRING
		sw = new StopWatch();
		sw.start();
		String str = "";
		for(int i=0; i<loop; i++){
			str += StringBuilderBufferDemo.class.getName();
			str += ".";
			str += StringBuilderBufferDemo.class.getSimpleName();
			str += "-";
			str += sw.getTotalTimeMillis();
		}
		sw.stop();
		System.out.println("String: " + sw.getLastTaskTimeMillis() + "ms");
		
	}
}
