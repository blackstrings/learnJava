package com.xai.regrex;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * <ul>
 * <li>Special Characters--> / | () [] {} ^ $ * + ? .</li>
 * <li>/ = indicates there will be a regex expression, methods with parameter accepting regex may not need forward slashes</li>
 * <li>| = represents the OR symbol '(a|c)' meaning a OR c</li>
 * <li>() = to group a pattern, (ace)* means a pattern of 'ace' </li>
 * <li>[] = indicate range, [a-c] means a,b, or c, [1-9] means 1,2,3,...9, [^3-8\-] means negate numbers between 3-8 and dashes</li>
 * <li>{} = indicate precise appearance, d{3} means ddd only, d[2,] means dd, ddd, ddddd etc., d{2,4} means dd,ddd,dddd only</li>
 * <li>? = there may or may not be, '/tu?/' means t, tu, tuk, tuu</li>
 * <li>+ = at least one, '/tu+/' means tu, tuk, tuu, tuok </li>
 * <li>^ = start with this, '/^k/' means k, ko, kop, etc</li>
 * <li>$ = ends with this, '(love)$' means ending with 'love'</li>
 * <li>. = wildcard, '^.{4}&' means a string with exactly 4 characters</li>
 * <li>\ = backslash will allow you to look for special characters, '\(' means look for "(" </li>
 * </ul>
 * @author xlao
 *
 */
public class MainRegex {

    public static void main(String[] args){
       
    	String section = null;
    	String str = null;
    	
    	section = "A1  ";
    	str = "111.222.333";
    	// split into 2 array [0032,000] grab index 0
    	// use backslash as . is a key symbol and \ is a key symbol as well
		str = str.split("\\.")[0];	
		print(section,str);						// 111
		
		//str.split("\\.")[1] gives you the other half
		
		section = "A2  ";
		str = "00110011";
		// ending in 11
		str = str.replaceAll("(11)$", "999");	
		print(section, str);					// 001100999
		
		section = "A2a ";
		str = "00110011";
		// beginning string pattern of leading zeros only
		str = str.replaceFirst("^0+(?!$)", "");
		print(section, str);					// 110011
		
		
		section = "A3  ";
		str ="00u00uu00uuu";
		// pattern with at least 1 u 
		// or more, u, uu, uuu, uuu...
		str = str.replaceAll("u+", "B");	
		print(section, str);					// 00B00B00B
		
		section = "A4  ";
		str ="00tu00tuu00tuuu";
		// pattern (tu) with at least 1 u
		// or more, u, uu, uuu, uuu...
		str = str.replaceAll("(tu+)", "B");	
		print(section, str);					// 00B00B00B
		
		section = "A5  ";
		str ="ccc000";
		// beginning character that start with "c"
		str = str.replaceAll("^c", "B");	
		print(section, str);					// Bcc000
		
		section = "A6  ";
		str ="ccc000ccc";
		// beginning of string that start with "c" and any repeating c
		str = str.replaceAll("^c+", "B");	
		print(section, str);					// B000ccc
		
		section = "A7  ";
		str ="ccc000cc000c";
		// replace all c with e
		str = str.replaceAll("c", "e");	
		print(section, str);					// eee000ee000e
		
		section = "A8  ";
		str ="I can hide but you can't";
		// replace everything starting with h and after
		// . is wildcard and + means any charcter
		// trim to remove white spaces
		str = str.replaceAll("(h.+)", "").trim();	
		print(section, str);					// I can
		
		section = "A9  ";
		str ="hh000acc000h";
		// single characters with range between a-c
		str = str.replaceAll("[a-c]", "e");	
		print(section, str);					// hh000eee000h
		
		section = "A10 ";
		str ="ee003330099";
		// single numbers with range between 1-3
		str = str.replaceAll("[1-3]", "e");	
		print(section, str);					// ee00eee0099
		
		section = "A11 ";
		str ="ee00eeee00e";
		// precise appearance of e 4 times
		str = str.replaceAll("e{4}", "1");	
		print(section, str);					// ee00100e

		section = "A12 ";
		str ="ee00eeee00eee";
		// precise appearance of eee and eeee only
		str = str.replaceAll("e{3,4}", "1");	
		print(section, str);					// ee00100e
		
		section = "A13 ";
		str ="12345678";
		// everything except 3,4,5
		str = str.replaceAll("[^3-5]", "e");	
		print(section, str);					// ee00100e
		
		section = "A14 ";
		str ="eu00ekc";
		// e, ek, e9, there may or may not be a "u" folowing e
		str = str.replaceAll("(eu?)", "F");	
		print(section, str);					// ee00100e
    	
    }
    
    private static void print(String section, String str){
    	System.out.println(section + " - " + str);
    }
}