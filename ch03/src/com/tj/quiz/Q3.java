package com.tj.quiz;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.print("첫번째 값을 입력하세요 : ");
		int i = scan1.nextInt();
		
		System.out.print("두번째 값을 입력하세요 : ");
		int i2 = scan2.nextInt();
		boolean result;
		
		// 같다
		result = i == i2;
		System.out.println(i +" == " + i2 +" 의 결과는 " + ((result == true)? "O": "X"));
		
		// 다르다
		result = i != i2;
		System.out.println(i +" != " + i2 +" 의 결과는 " + ((result == true)? "O": "X"));
		
		// 크다
		result = i > i2;
		System.out.println(i +" > " + i2 +" 의 결과는 " + ((result == true)? "O": "X"));
		
		// 작다
		result = i < i2;
		System.out.println(i +" < " + i2 +" 의 결과는 " + ((result == true)? "O": "X"));
		
		// 크거나 같다
		result = i >= i2;
		System.out.println(i +" >= " + i2 +" 의 결과는 " + ((result == true)? "O": "X"));
		
		// 작거나 같다
		result = i <= i2;
		System.out.println(i +" <= " + i2 +" 의 결과는 " + ((result == true)? "O": "X"));
		
//		System.out.println(i == i2 ? i+"=="+i2 + "은(는) O" : i+"=="+i2 + "은(는) X"); 
//		System.out.println(i > i2 ? i+">"+i2 + "은(는) O" : i+">"+i2 + "은(는) X");  //크다
//		System.out.println(i < i2 ? i+"<"+i2 + "은(는) O" : i+"<"+i2 + "은(는) X");  //작다
//		System.out.println(i >= i2 ? i+">="+i2 + "은(는) O" : i+">="+i2 + "은(는) X");  // 크거나같다
//		System.out.println(i <= i2 ? i+"<="+i2 + "은(는) O" : i+"<="+i2 + "은(는) X");  //작거나같다
		
		scan1.close();
		scan2.close();
	}
}
