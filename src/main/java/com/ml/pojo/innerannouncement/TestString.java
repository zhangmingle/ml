package com.ml.pojo.innerannouncement;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class TestString {

	public static void main(String[] args) {

/*        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);// fasle
        //System.out.println(s1.equals(s2));// true
        System.out.println(s1 == s5);// true
        //System.out.println(s1.equals(s5));// true
        System.out.println(s1 == s6);
        //System.out.println(s1.equals(s6));// true
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());*/
		
		System.out.println(Math.random()*52);
		
		
		TestString.innerClass.staticPrint();
		TestString.innerClass1 innerClass1 = new TestString().new innerClass1();
		innerClass1.staticPrint1();
		
		String a = "asdfghjkl";
		System.out.println(a.substring(a.length()-1));
		
		System.out.println(reverse("asdfghjkl"));
		System.out.println(reverse1("asdfghjkl"));

		
		Hashtable<String, String> map = new Hashtable<String, String>();
		map.put("1", "asd");
		map.put(null, "ghj");
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		System.out.println(map.size());
		
	}
	
	public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
	
	public static String reverse1(String originStr) {
		StringBuilder sb = new StringBuilder();
		while(originStr.length() > 0){
    	 sb.append(originStr.substring(originStr.length()-1));
    	 originStr = originStr.substring(0,originStr.length()-1);
		}
		return  sb.toString();
    }
	
	
	
	
	public static class innerClass {
		public static void staticPrint() {
			System.out.println("static");
		}
	}
	
	public class innerClass1 {
		public void staticPrint1() {
			System.out.println("asdasd");
		}
	}
}
