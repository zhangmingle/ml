package com.ml.handler;

import com.ml.annotation.Audit;
import com.ml.pojo.innerannouncement.Item;

/*@Service*/
public class ItemHandler{
	
	@Audit
	public String updateItem(Item item) {

		System.out.println(1111);
		return item.getDetail(); 
	}


	public String selectItem1(Item item) {

		System.out.println(1111);
		return item.getDetail(); 
	}
}
