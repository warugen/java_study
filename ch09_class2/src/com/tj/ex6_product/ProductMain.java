package com.tj.ex6_product;

public class ProductMain {
	public static void main(String[] args) {
		
		Product p1 = new Product("냉장고");
		Product p2 = new Product("냉장고");
		Product p3 = new Product("냉장고");
		
		System.out.println(p1.infoString());
		System.out.println(p2.infoString());
		System.out.println(p3.infoString());
	}
}
