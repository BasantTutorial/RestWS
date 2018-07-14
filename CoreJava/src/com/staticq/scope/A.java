package com.staticq.scope;

public class A {
	static {
		Common.a=200;
		
		System.out.println(Common.a);
	}

	public static void main(String[] args) {

	}
}
