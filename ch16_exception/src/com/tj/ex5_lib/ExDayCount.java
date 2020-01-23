package com.tj.ex5_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ExDayCount {
	public static void main(String[] args) {
		Date checkOutDate = new Date(new GregorianCalendar(2019, 11, 10).getTimeInMillis());
		Date now = new Date();
		long checkOutMillis = checkOutDate.getTime();	// 1970.01.01~2019.11.13까지 밀리세컨
		long nowMillis = now.getTime();	// // 1970.01.01~2019.12.13까지 밀리세컨
		long diff = nowMillis - checkOutMillis;	// 빌린동안의 밀리세컨
		long day = diff/(24*60*60*1000);
		System.out.println(day);
		
		if (day > 14) {
			System.out.println("연체료발생 "+((day-14)*100)+"원 연체료");
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료를 받으셨나요?(Y/N:반납중단)");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("반납중단되었습니다.");
				System.exit(0);	//체크인함수에서는 return 처리
			}
		}
		System.out.println("반납처리");
	}
}
