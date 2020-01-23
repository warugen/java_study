package com.tj.op;
// 삼항연산자
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
		
		String result = (h%2 == 0) ? "짝수" : "홀수";
		System.out.println(result);
		
		System.out.println((h%2 == 0) ? "짝수" : "홀수");
	}

}
