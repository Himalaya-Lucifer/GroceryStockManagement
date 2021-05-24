package com.himalaya.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.himlaya.model.Item;



public class ItemDAOImpl implements ItemDAO{

	@Override
	public List<Item> getItem() throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Item> items = new ArrayList<Item>();
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from grocery");
			rs = ps.executeQuery();	
			
			while(rs.next()) {
				int itemCode = rs.getInt(1);
				String itemName = rs.getString(2);
				String unit = rs.getString(3);
				int beginningInventory = rs.getInt(4);
				int quantityOnHand = rs.getInt(5);
				double pricePerUnit =rs.getDouble(6);
				Date dateOfManufature = rs.getDate(7);
				Date dateOfExpiry = rs.getDate(8);
				String location = rs.getString(9);
				String itemCategory = rs.getString(10);
				
				Item item=new Item(itemCode, itemName, unit, beginningInventory, quantityOnHand, pricePerUnit, dateOfManufature, dateOfExpiry, location, itemCategory);
				items.add(item);
		}
		}
		finally {
			con.close();
		}
		
		return items;
	}

	@Override
	public void addItem(Item item) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert grocery(item_name,unit,beginning_inventory,quantity_on_hand,price_per_unit,date_of_manufacture,date_of_expiry,location,category) values(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, item.getItemName());
			ps.setString(2, item.getUnit());
			ps.setInt(3, item.getBeginningInventory());
			ps.setInt(4, item.getQuantityOnHand());	
			ps.setDouble(5, item.getPricePerUnit());
			ps.setTimestamp(6,new java.sql.Timestamp(item.getDateOfManufature().getTime()));
			ps.setTimestamp(7, new java.sql.Timestamp(item.getDateOfExpiry().getTime()));
			ps.setString(8, item.getLocation());
			ps.setString(9,item.getItemCategory());
		
		
		ps.executeUpdate();	
	}
		finally {
		con.close();
	}
	}

	@Override
	public Item getItem(int itemCode) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Item item = null;
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from grocery where item_code=?");
			ps.setInt(1, itemCode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String itemName = rs.getString(2);
				String unit = rs.getString(3);
				int beginningInventory = rs.getInt(4);
				int quantityOnHand = rs.getInt(5);	
				double pricePerUnit = rs.getDouble(6);	
				Date dateOfManufature = rs.getDate(7);
				Date dateOfExpiry = rs.getDate(8);
				String location = rs.getString(9);
				String itemCategory = rs.getString(10);
				
				item = new Item(itemCode, itemName, unit, beginningInventory, quantityOnHand, pricePerUnit, dateOfManufature, dateOfExpiry, location, itemCategory);
					
			}else {
				throw new Exception("Cloud not found item code : "+itemCode);
			}
			
		}finally {
			con.close();
		}
		return item;
	}

	@Override
	public void updateItem(Item item) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("update grocery set item_name=?,unit=?,beginning_inventory=?,quantity_on_hand=?, price_per_unit=?, date_of_manufacture=?, date_of_expiry=?, location=?,category=? where item_code=?");
	                                                                                                                                    		                                                           
				
			ps.setString(1, item.getItemName());
			ps.setString(2, item.getUnit());
			ps.setInt(3, item.getBeginningInventory());
			ps.setInt(4, item.getQuantityOnHand());	
			ps.setDouble(5, item.getPricePerUnit());
			ps.setTimestamp(6,new java.sql.Timestamp(item.getDateOfManufature().getTime()));
			ps.setTimestamp(7, new java.sql.Timestamp(item.getDateOfExpiry().getTime()));
			ps.setString(8, item.getLocation());
			ps.setString(9,item.getItemCategory());
			ps.setInt(10,item.getItemCode());
		
			ps.executeUpdate();
		}finally {
			con.close();
		}
		
	}

	@Override
	public void deleteItem(int itemCode) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("delete from grocery where item_code=?");
			ps.setInt(1,itemCode);
			
			
			ps.executeUpdate();
		}finally {
			con.close();
		}
		
	}

	@Override
	public List<Item> searchItem(String searchName) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Item> items = new ArrayList<Item>();
		
		try {
			con = ConnectionFactory.getCon();
			
			if(searchName!=null && searchName.trim().length()>0) {
				
			ps = con.prepareStatement("select * from grocery where lower(item_name) like ?");
			ps.setString(1,"%"+searchName.toLowerCase()+"%");
			
		} else {
			
			ps = con.prepareStatement("select * from grocery order by item_name");
		}
		
			rs = ps.executeQuery();	
			
			    while(rs.next()){
				int itemCode = rs.getInt(1);
				String itemName = rs.getString(2);
				String unit = rs.getString(3);
				int beginingInventory = rs.getInt(4);
				int quantityOnHand = rs.getInt(5);
				double pricePerUnit =rs.getDouble(6);
				Date dateOfManufature = rs.getDate(7);
				Date dateOfExpiry = rs.getDate(8);
				String location = rs.getString(9);
				String itemCategory = rs.getString(10);
				
				Item item = new Item(itemCode, itemName, unit, beginingInventory, quantityOnHand, pricePerUnit, dateOfManufature, dateOfExpiry, location, itemCategory);
		
				items.add(item);
			}
		
		}
			   finally {
			con.close();
		}
		
		
		return items;
	}
	
	}


