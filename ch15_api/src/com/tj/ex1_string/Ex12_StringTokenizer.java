package com.tj.ex1_string;

import java.util.StringTokenizer;

public class Ex12_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2019/12/10";
		
		StringTokenizer token1 = new StringTokenizer(str1);
		StringTokenizer token2 = new StringTokenizer(str2, "/");
		
		System.out.println("token1의 토큰갯수 : "+token1.countTokens());
		
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}

		System.out.println("token2의 토큰갯수 : "+token2.countTokens());
		
		while(token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}
	}
}
