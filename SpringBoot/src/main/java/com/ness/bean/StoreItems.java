package com.ness.bean;

public class StoreItems {
	private String itemCode;
	private int quantity;
	private float price;
	private String branded;
	
	public StoreItems(String itemCode, int quantity, float price, String branded) {
		super();
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.price = price;
		this.branded = branded;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBranded() {
		return branded;
	}
	public void setBranded(String branded) {
		this.branded = branded;
	}
}
