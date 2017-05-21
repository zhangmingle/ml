package com.ml.test;

public class InnerClass {


		boolean aa = false;
		static int bb = 123;

	
	
	static class IInnerClass {
		static int bb = 321;
		public static void main(String[] args) {
			System.out.println(InnerClass.bb);
		}
	}
}
