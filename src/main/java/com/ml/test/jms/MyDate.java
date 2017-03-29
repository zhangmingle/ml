package com.ml.test.jms;

import java.lang.ref.WeakReference;
import java.util.Date;

public class MyDate extends Date {

	 /** Creates a new instance of MyDate */
    public MyDate() {
    	System.out.println("实例化");
    }
    // 覆盖finalize()方法
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() + "] is gc");
    }   

    public String toString() {
        return "Date: " + this.getTime();
    }
    
    public void hh() {
		System.out.println("hh");
	}
    
    public static void main(String[] args) {
    	MyDate mydate = new MyDate();
    	WeakReference ref = new WeakReference(new MyDate());
        mydate.hh();
        ReferenceTest.drainMemory();
        // System.gc();
	}
    
}
