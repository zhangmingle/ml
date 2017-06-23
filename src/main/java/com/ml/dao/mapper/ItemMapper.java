package com.ml.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.ml.pojo.innerannouncement.Item;

public interface ItemMapper {
	
	public Item selectItemById(@Param("id") int id);
        
    public void inserItem(Item item);
    
    public void updateItem(Item item);
    
    public void deleteItem(@Param("itemId") int itemId);
    
}
