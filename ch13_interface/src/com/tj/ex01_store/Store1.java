package com.tj.ex01_store;
// 주택가 : 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
public class Store1 implements HeadStore {
	private String str = "주택가1호점";
	
	@Override
	public void budae() {
		
		System.out.println("부대찌개 5,000원");
	}
	
	@Override
	public void sundae() {
		System.out.println("순대국 안팔아");
	}
	
	@Override
	public void kimch() {
		System.out.println("부대찌개 5,000원");
		
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 6,000원");
		
	}

	@Override
	public void gongibap() {
		System.out.println("공기밥 1,000원");
		
	}
	
	public String getStr() {
		return str;
	}
}
