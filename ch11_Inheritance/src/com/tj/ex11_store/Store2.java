package com.tj.ex11_store;
// 대학가 : 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
public class Store2 extends HeadStore {
	private String str = "대학가2호점";
	
	@Override
	public void budae() {
		System.out.println("부대찌개 5,000원");
	}
	
	@Override
	public void bibim() {
		System.out.println("비빔밥 5,000원");
	}
	
	@Override
	public void gongibap() {
		System.out.println("공기밥 무료");
	}
	
	public String getStr() {
		return str;
	}
}
