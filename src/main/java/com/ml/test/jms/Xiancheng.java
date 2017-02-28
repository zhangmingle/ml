package com.ml.test.jms;

import java.util.HashMap;

public class Xiancheng {
	 static HashMap<Integer, Integer> map = new HashMap<>();
	    //分别在两个子线程内对hashmap进行put,get操作
	    public static void main(String[] args) {

	        new Thread(new Runnable() {

	            @Override
	            public void run() {
	                // TODO Auto-generated method stub
	                System.out.println("线程1执行");
	                for (int i = 0; i < 1000; i++) {
	                    map.put(i,i);
	                }
	                System.out.println("线程1---------" + map.get(500));
	                //System.out.println("线程1---------" + map.get(1500));
	            }
	        }).start();
	        new Thread(new Runnable() {

	            @Override
	            public void run() {
	                // TODO Auto-generated method stub
	                System.out.println("线程2执行");
	                for (int i = 1000; i < 2000; i++) {
	                    map.put(i, i);
	                }
	                System.out.println("线程2---------" + map.get(1500));
	                //System.out.println("线程2---------" + map.get(500));
	            }
	        }).start();
	    }
}
