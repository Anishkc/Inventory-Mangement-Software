package com.creativeInfotechSolution.service;

import java.util.List;

import com.creativeInfotechSolution.model.Item;


public interface ItemService {
	
    boolean addItem(Item item);
	
	boolean deleteItem(int id);
	
	boolean updateItemQuantity(Item item);
	
	boolean updateItem(Item item);
	
	Item getById(int id);
	
	List<Item> getAllItem();
	
	List<Item> searchItem(String input);

}
