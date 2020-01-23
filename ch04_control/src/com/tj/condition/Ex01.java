package com.tj.condition;
// if 조건문
public class Ex01 {
	public static void main(String[] args) {
		int i = 10, j = 20, hap = 30;
		
		if(i+j == hap) {
			System.out.println("i + j = "+hap+"입니다.");
		}
		
		if (i > j) {
			System.out.println("i는 j보다 크다");
		} else {
			System.out.println("i는 j보다 크지않다");
		}
		
	}

}
