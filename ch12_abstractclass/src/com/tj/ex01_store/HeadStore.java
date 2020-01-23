package com.tj.ex01_store;
// 본사 : 김치찌개-0  부대찌개-0  비빔밥-0 순대국-0  공기밥-0원
public abstract class HeadStore {
	private String str = "본사";
	
	// 추상 메소드 : 선언부만 있는 메소드(구현부는 없음)
	public abstract void kimch();
	
	public abstract void budae();
	
	public abstract void bibim();
	
	public abstract void sundae();
	
	public abstract void gongibap();
	
	public String getStr() {
		return str;
	}
}
