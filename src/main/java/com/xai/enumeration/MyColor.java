package com.xai.enumeration;

public class MyColor {
	private MyColor() {} //prevent others from making myColor
	public static final MyColor RED = new MyColor();
	public static final MyColor GREEN = new MyColor();
	public static final MyColor BLUE = new MyColor();
}
