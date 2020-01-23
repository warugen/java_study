package com.tj.ex;
// method화 - sum(1,10), evenOdd(500)
public class Ex02 {
	public static void main(String[] args) {
		
//		int sum = sum(1,10);
		
		int sum = sum(10);
		
//		int tot = 0;
//		for (int i = 0; i <= 10; i++) {
//			tot += i;
//		}
		System.out.println("1~10까지 정수합은 " + sum + "입니다");
		//System.out.println((sum % 2 == 0) ? "짝수입니다" : "홀수입니다");
		System.out.println(evenOdd(sum));
		
		
		sum = sum(10,100);
//		for (int i = 10; i < 100; i++) {
//			tot += i;
//		}
		System.out.println("10~100까지 정수합은 " + sum + "입니다");
//		System.out.println((sum % 2 == 0) ? "짝수입니다" : "홀수입니다");
		System.out.println(evenOdd(sum));

		
	}
	
	private static int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}
	
	private static int sum(int value) {
		int result = 0;
		for (int i = 0; i <= value; i++) {
			result += i;
		}
		return result;
	}
	
	private static String evenOdd(int in) {
		return (in % 2 == 0) ? "짝수입니다" : "홀수입니다";
	}
}
