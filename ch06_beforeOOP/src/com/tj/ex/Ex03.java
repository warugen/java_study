package com.tj.ex;
// Airthmetic안의 sum, evenOdd, abs 사용하기

import com.tj.method.Airthmetic;

public class Ex03 {
	public static void main(String[] args) {
		Airthmetic ar = new Airthmetic();
		int tot = ar.sum(10, 100);
		System.out.println(tot);
		System.out.println(ar.evenOdd(tot));
		System.out.println("-5의 절대값은 : " + Airthmetic.abs(-5));
		
	}
}
