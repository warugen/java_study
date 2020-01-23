package com.tj.ex6_product;

public class Product {
	public static int count = 100;
	private int serialNo;
	private String name;
	
	public Product() {}
	public Product(String name) {
		this.serialNo = ++count;
		this.name = name;
	}
	
	public String infoString() {
		return "serialNo = "+serialNo+"\t물품명 : "+name;
	}
	
	public void print() {
		System.out.println("serialNo = "+serialNo+"\t물품명 : "+name);
	}
}
