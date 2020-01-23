package com.tj.ex4_object;

public class Goods {
	private String goodsCode;	// 상품코드
	private String goodsName;	// 상품이름
	private int    goodsPrice;	// 상품가격
	private int    stockNum;	// 재고수량
	
	public Goods() {}
	// Goods g = new Goods("a01", "새우깡", 1500, 10);
	public Goods(String goodsCode, String goodsName, int goodsPrice, int stockNum) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stockNum = stockNum;
	}
	@Override
	public String toString() {
		
		return goodsName+"("+goodsCode+") : "+goodsPrice+"원. 재고"+stockNum+"개";
	}
	
	
}
