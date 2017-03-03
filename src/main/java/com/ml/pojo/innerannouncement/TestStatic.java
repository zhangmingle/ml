package com.ml.pojo.innerannouncement;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestStatic {


	public static void main(String[] args) {
		TestStatic.function();
	}

	static {
		System.out.println("2");
	}
	static TestStatic my = new TestStatic();
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

	static int b = 12;
	Integer a = new Integer(1);

}