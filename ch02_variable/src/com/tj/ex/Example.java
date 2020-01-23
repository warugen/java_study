package com.tj.ex;

public class Example {
	public static void main(String[] args) {
		// 국어, 영어, 수학, 총점 변수 선언
//		int kor, eng, math, total;
		double kor, eng, math, total;
		
		// 평균 변수 선언
		double avg;
		
		// 국,영,수 점수 임의 부여
		kor = 86.5;
		eng = 100;
		math = 88.8;
		
		// 총점 구하기
		total = kor + eng + math;
		 
		// 평균 구하기
		avg = total / 3.0;
		
		
		// 출력하기
		
//		System.out.println("국어 = " + kor);
//		System.out.println("영어 = " + eng);
//		System.out.println("수학 = " + math);
//		
//		System.out.println("총점 = " + total);
		
		System.out.printf("국어 = %.2f\n" , kor);
		System.out.printf("영어 = %.2f\n" , eng);
		System.out.printf("수학 = %.2f\n" , math);
		
		System.out.printf("총점 = %.2f\n" , total);
		
		System.out.printf("평균 = %.2f\n", avg);
	}
}
