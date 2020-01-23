package com.tj.ex11_store;
// 본사 : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public class HeadStore {
	private String str = "본사";
	public void kimch() {
		System.out.println("김치찌개 5,000원");
	}
	
	public void budae() {
		System.out.println("부대찌개 6,000원");
	}
	
	public void bibim() {
		System.out.println("비빔밥 6,000원");
	}
	
	public void sundae() {
		System.out.println("순대국 5,000원");
	}
	
	public void gongibap() {
		System.out.println("공기밥 1,000원");
	}
	
	public String getStr() {
		return str;
	}
}
