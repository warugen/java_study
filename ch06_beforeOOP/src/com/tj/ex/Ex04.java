package com.tj.ex;

import java.util.Scanner;

// 팩토리얼
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su =0;
		do {
			System.out.print("몇 !을 계산할까요? : ");
			su = sc.nextInt();
						
		}while(su<=0);
		
		long result = factorial(su);
		System.out.println(su + "! = "+ result);
	}

	private static long factorial(int su) {
		if (su == 1) {
			return 1;
		} else {
			return su * factorial(su-1);
		}
		
	}

//	private static long factorial(int su) {
//		long result = 1;;
//		
//		for (int i = su; i >= 1 ; i--) {
//			result = result * i;
//		}
//				
//		return result;
//	}
	
	
}
