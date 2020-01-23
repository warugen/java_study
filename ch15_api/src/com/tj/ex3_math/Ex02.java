package com.tj.ex3_math;

public class Ex02 {
	public static void main(String[] args) {
		// 반올림, 올림, 내림
		System.out.println("소수점에서 반오림, 올림, 내림");
		// 9.12->반올림:9.0 올림:10.0 내림:9.0
		System.out.println("9.12를 반올림 : "+ Math.round(9.12));
		System.out.println("9.12를 올림   : "+ Math.ceil(9.12));
		System.out.println("9.12를 내림   :"+ Math.floor(9.12));
		
		// 9.56 -> 9.6 으로
		System.out.println("소수점 한자리에서 반올림, 올림, 내림");
		System.out.println("9.56을 소수점 한자리에서 반올림 : " + Math.round(9.56*10)/10.0);
		System.out.println("9.56을 소수점 한자리에서 올림   : " + Math.ceil(9.56*10)/10.0);
		System.out.println("9.56을 소수점 한자리에서 내림   : " + Math.floor(9.56*10)/10);
		
		// 19 -> 20 20 10 으로
		System.out.println("19를 일의 자리에서 반올림, 올림, 내림");
		System.out.println("19를 반올림 : "+Math.round(19/10.0)*10);
		System.out.println("19를 올림   : "+Math.ceil(19/10.0)*10);
		System.out.println("19를 내림   : "+Math.floor(19/10.0)*10);
	}
}
