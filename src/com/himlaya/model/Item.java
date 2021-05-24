package com.himlaya.model;

import java.util.Date;

public class Item {
	
	private int itemCode;
	private String itemName;
	private String unit;
	private int beginningInventory;
	private int quantityOnHand;
	private double pricePerUnit;
	private Date dateOfManufature;
	private Date dateOfExpiry;
	private String location;
	private String itemCategory;
	
	public Item(int itemCode, String itemName, String unit, int beginningInventory, int quantityOnHand,
			double pricePerUnit, Date dateOfManufature, Date dateOfExpiry, String location, String itemCategory) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unit = unit;
		this.beginningInventory = beginningInventory;
		this.quantityOnHand = quantityOnHand;
		this.pricePerUnit = pricePerUnit;
		this.dateOfManufature = dateOfManufature;
		this.dateOfExpiry = dateOfExpiry;
		this.location = location;
		this.itemCategory = itemCategory;
	}

	public Item(String itemName, String unit, int beginningInventory, int quantityOnHand, double pricePerUnit,
			Date dateOfManufature, Date dateOfExpiry, String location, String itemCategory) {
		super();
		this.itemName = itemName;
		this.unit = unit;
		this.beginningInventory = beginningInventory;
		this.quantityOnHand = quantityOnHand;
		this.pricePerUnit = pricePerUnit;
		this.dateOfManufature = dateOfManufature;
		this.dateOfExpiry = dateOfExpiry;
		this.location = location;
		this.itemCategory = itemCategory;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getBeginningInventory() {
		return beginningInventory;
	}

	public void setBeginningInventory(int beginningInventory) {
		this.beginningInventory = beginningInventory;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Date getDateOfManufature() {
		return dateOfManufature;
	}

	public void setDateOfManufature(Date dateOfManufature) {
		this.dateOfManufature = dateOfManufature;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", itemName=" + itemName + ", unit=" + unit + ", beginningInventory="
				+ beginningInventory + ", quantityOnHand=" + quantityOnHand + ", pricePerUnit=" + pricePerUnit
				+ ", dateOfManufature=" + dateOfManufature + ", dateOfExpiry=" + dateOfExpiry + ", location=" + location
				+ ", itemCategory=" + itemCategory + "]";
	}
	
	

}
