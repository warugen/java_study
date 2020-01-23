package com.tj.ex1_string;

public class Ex11_speedcheck {
	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());	// 1970.01.01.0시부터 현재의 밀리세컨
		String str = "A";
		long startT = System.currentTimeMillis();
		for (int i=0; i < 50000; i++) {
			str = str+"a";
		}
		long endT = System.currentTimeMillis();
		
		System.out.println("String 5만번 수정 경과 시간 : "+(endT-startT));
		
		StringBuffer strbuf = new StringBuffer("A");
		startT=System.currentTimeMillis();
		for(int i=0; i < 500000; i++) {
			strbuf.append("a");
		}
		endT = System.currentTimeMillis();
		System.out.println("StringBuffer 50만번 수정 경과 시간 : "+(endT-startT));
		
		StringBuilder strbd = new StringBuilder("A");
		startT=System.currentTimeMillis();
		for(int i=0; i < 500000; i++) {
			strbd.append("a");
		}
		endT = System.currentTimeMillis();
		System.out.println("StringBuilder 50만번 수정 경과 시간 : "+(endT-startT));
		
	}
}
