package com.ml.test.jms;

import java.util.Hashtable;

public class VolatileTest {

	   public int count = 0;
	   static Hashtable<Integer, Integer> table = new Hashtable<>();
	    
	    public  void inc() {
	 
	        //这里延迟1毫秒，使得结果明显
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	        }
	 
	        count++;
	    }
	 
	    public static void main(String[] args) {
	 
	        //同时启动1000个线程，去进行i++计算，看看实际结果
	    	final VolatileTest volatileTest = new VolatileTest();
	    	
	        for (int i = 0; i < 1000; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                	volatileTest.inc();
	                	for (int j = 0; j < 1000; j++) {
	                		table.put(j, j);
	                	}
	                	System.out.println(table.get(100));
	                }
	            }).start();
	        }
	 
	        //这里每次运行的值都有可能不同,可能为1000
	        System.out.println("运行结果:Counter.count=" + volatileTest.count);
	    }
}