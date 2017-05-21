package com.ml.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.ml.pojo.innerannouncement.TestString.innerClass1;

public class ParentTestStatic {
	
	

	static int b = 112;
	Integer a = new Integer(11);

	//static ParentTestStatic my = new ParentTestStatic();
	
	static {
		System.out.println("p2");
	}

	{
		System.out.println("p1");
	}

	ParentTestStatic() {
		System.out.println("p3");
		System.out.println("a=" + a + ",b=" + b);
	}


}