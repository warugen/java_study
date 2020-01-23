package com.tj.ex2_date;

import java.util.GregorianCalendar;

public class Ex03_gc {
	public static void main(String[] args) {
		GregorianCalendar gcnow = new GregorianCalendar();
		
		System.out.println("1970년 1월 1일 0시 0분 0초부터 지금까지의 밀리세컨은 다음과 같다.");
		System.out.println(System.currentTimeMillis());
		
		System.out.println(gcnow.getTimeInMillis());	// 1970.01.01부터 gc시점까지의 밀리세컨
		
		GregorianCalendar gcThat = new GregorianCalendar(2019, 10, 25, 9, 30, 0);
		System.out.println(gcThat.getTimeInMillis());
	}
}
