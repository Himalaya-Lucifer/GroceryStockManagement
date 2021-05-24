package com.himalaya.data;

import java.util.List;

import com.himlaya.model.Item;

public interface ItemDAO {
	public List<Item> getItem()throws Exception;
	public void addItem(Item item) throws Exception;
	public Item getItem(int itemCode) throws Exception;
	public void updateItem(Item item) throws Exception;
	public void deleteItem(int itemCode) throws Exception;
	public List<Item> searchItem(String searchName) throws Exception;


}
