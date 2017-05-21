package com.ml.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.ml.pojo.innerannouncement.TestString;
import com.ml.pojo.innerannouncement.TestString.innerClass;
import com.ml.pojo.innerannouncement.TestString.innerClass1;

public class TestStatic extends ParentTestStatic {
	
	

	static int b = 12;
	Integer a = new Integer(1);
	
	public static void main(String[] args) {
		TestStatic.function();
		
		TestString.innerClass.staticPrint();
		TestString.innerClass1 innerClass1 = new TestString().new innerClass1();
		innerClass1.staticPrint1();
	}
	static TestStatic my = new TestStatic();
	
	static {
		System.out.println("2");
	}

	{
		System.out.println("1");
	}

	TestStatic() {
		System.out.println("3");
		System.out.println("a=" + a + ",b=" + b);
	}

	static void function() {
		System.out.println("4");
	}


}