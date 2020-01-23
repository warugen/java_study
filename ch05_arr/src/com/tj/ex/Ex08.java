package com.tj.ex;

// 일반for vs 확장for
public class Ex08 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30};
		
		int tmp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			tmp = (int) (arr[i] * 1.1);
			arr[i] = tmp;
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		arrayPrint(arr);

		
		for(int a : arr) {
			a *= 2;
		}
		
		arrayPrint(arr);
	}
	
	private static void arrayPrint(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
