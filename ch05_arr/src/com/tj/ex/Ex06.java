package com.tj.ex;
// arr = {10,20,30,40,50} 배열값을 누적한 합을 출력하는 프로그램
public class Ex06 {
	public static void main(String[] args) {

		int[] arr = {10,20,30,40,50,60,70,80,90,100,110};
		int tot = 0;
		
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		
		System.out.println("배열의 누적합 = " + tot);
	}
}
