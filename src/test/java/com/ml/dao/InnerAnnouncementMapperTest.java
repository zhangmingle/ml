package com.ml.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ml.dao.mapper.InnerAnnouncementMapper;
import com.ml.pojo.innerannouncement.InnerAnnouncement;

public class InnerAnnouncementMapperTest extends AbstractPersistenceTest {

	@Autowired
	private InnerAnnouncementMapper mapper;
	
	//@Test
	public void test() throws Exception {
		
		InnerAnnouncement ia = new InnerAnnouncement();
		Date now = new Date();
		
		ia.setContent("你好");
		ia.setSummary("Hello World");
		ia.setTitle("test");
		ia.setCreatedByCode("100");
		ia.setCreatedByName("卷福");
		ia.setUpdatedByCode("100");
		ia.setUpdatedByName("卷福");
		ia.setCreateTime(now);
		ia.setStartTime(now);
		ia.setUpdateTime(now);
		mapper.insertInnerAnnouncement(ia);
	}


	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		 
/*	      Class cache = Integer.class.getDeclaredClasses()[0]; //1
	      Field myCache = cache.getDeclaredField("cache"); //2
	      myCache.setAccessible(true);//3
	 
	      Integer[] newCache = (Integer[]) myCache.get(cache); //4
	      newCache[130] = newCache[131]; //5
	 
	      int a = 2;
	      int b = a + a;
	      System.out.printf("%d + %d = %d", a, a, b); //
	    }*/

	    List<Integer> list = new CopyOnWriteArrayList<Integer>();  
	    list.add(0);  
	    list.add(1);  
	    list.add(2);  
	    list.add(3);  
	    list.add(4);  
	    list.add(5);  
	    list.add(6);  
	    list.add(7);
	    System.out.println(list);
	    for (Integer Integer : list) {
	    	if (Integer == 3) {
	    		list.remove(Integer);
	    	}
	    }
	    System.out.println(list);
/*	    //正常循环  
	    for (int i = 0; i < list.size(); i++) {  
	        System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));  
	    }  
	    System.out.println("没有remove前list的项:"+list.size());  
	      
	    //边循环边删除  
	    for (int i = list.size() -1 ; i >= 0; i--) {  
	        System.out.println("i的值  " + i + " 对应的数字 " + list.get(i));  
	        if(list.get(i) == 3) list.remove(list.get(i));  
	    }  
	    System.out.println("remove后list的项:"+list.size());  
	      
	    System.out.println("==========remove后的list==========");  
	    for (int i = 0; i < list.size(); i++) {  
	        System.out.println("i的值  " + i + " 对应的数字 " + list.get(i));  
	    }*/
	}    
}
