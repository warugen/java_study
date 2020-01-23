package com.tj.ex01_store;
// 증권가3호점 : 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class Store3 extends HeadStore {
	private String str = "증권가3호점";
	
	@Override
	public void kimch() {
		System.out.println("김치찌개 6,000원");
	}
	
	@Override
	public void budae() {
		System.out.println("부대찌개 7,000원");
	}
	
	@Override
	public void bibim() {
		System.out.println("비빔밥 7,000원");
	}
	
	@Override
	public void sundae() {
		System.out.println("순대국 6,000원");
	}
	
	public String getStr() {
		return str;
	}

	@Override
	public void gongibap() {
		System.out.println("공기밥 1,000원");
		
	}
}
