package com.tj.ex;

//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 
//값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요. 
public class Ex10 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		
		int tot=0, avg=0, max=0, min=9999;
		
		// 일반 for
//		for (int i = 0; i < arr.length; i++) {
//			tot += arr[i];
//			if (max < arr[i]) {
//				max = arr[i];
//			}
//			
//			if(min > arr[i]) {
//				min = arr[i];
//			}
//		}
		
		// 확장 for
		for(int a : arr) {
			tot += a;
			if (max < a) {
				max = a;
			}
			
			if(min > a) {
				min = a;
			}
		}
		
		avg = tot / arr.length;
		
		System.out.println("합   계 = " + tot +"\t평   균 = "+avg + "\n최대값은 = " + max + "\t최소값은 = " + min);
	}
}
