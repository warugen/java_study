package com.tj.ex;

public class Ex01 {
	public static void main(String[] args) {
//		int i = 1;							// 변수선언과 초기화
		int[] iArr = {10, 20, 30, 40, 50};	// 배열선언과 초기화
//		System.out.println(iArr[2]);
		
		for (int j = 0; j < iArr.length; j++) {
			System.out.println(iArr[j]);
		}
		
		System.out.println("*****************************************************");
		
		int[] iArr2 = new int[5];		// 배열선언과 배열메모리할당
		
		for (int j = 0; j < iArr2.length; j++) {
			System.out.println(iArr2[j]);
		}
		
		System.out.println("*****************************************************");
		
		
		int[] iArr3;					// 배열선언
		iArr3 = new int[5];
		iArr3[0] = 100;
		for (int j = 0; j < iArr3.length; j++) {
			System.out.println(iArr3[j]);
		}
	}
}
