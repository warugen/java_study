package com.tj.ex;

public class VarEx07 {
	public static void main(String[] args) {
		byte b = 10;
		int i = b;
		double d = 10; // d에 10.1이 들어간다. 묵시적 형변환
		
		double d2 = 10.91;
		int i2 = (int)d2; // 명시적 형변환 - 데이타 손실이 발생할 수 있다.
		
		i2 = (10+20+30)/7;
		
	}

}
