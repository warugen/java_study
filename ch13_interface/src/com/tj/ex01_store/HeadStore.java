package com.tj.ex01_store;
// 인터페이스 : 추상메소드와 public 상수만 가능
public interface HeadStore {
		
	// 추상 메소드 : 선언부만 있는 메소드(구현부는 없음)
	public void kimch();
	
	public void budae();
	
	public void bibim();
	
	public void sundae();
	
	public void gongibap();
	
	public double PI = 3.141;		// 자동으로 static final이 선언된걸로 인식
	
	
}
