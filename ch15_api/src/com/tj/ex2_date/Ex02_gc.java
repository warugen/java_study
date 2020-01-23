package com.tj.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

// 그레고리안 켈린더
public class Ex02_gc {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		int year = gc.get(Calendar.YEAR);		// 2019
		int month = gc.get(Calendar.MONTH)+1;	// 0,1,2,....11월 까지 +1해줘야한다.
		int day = gc.get(Calendar.DAY_OF_MONTH);	// 날짜
		int week = gc.get(Calendar.DAY_OF_WEEK);	// 일요일=1,월요일=2,...토요일=7
		int hour24 = gc.get(Calendar.HOUR_OF_DAY);	// 24시간 단위 시간
		int ampm = gc.get(Calendar.AM_PM);		// am/pm 시간 0 or 1
		int hour = gc.get(Calendar.HOUR);		// 12시간 단위 시간
		int minite = gc.get(Calendar.MINUTE);	// 분
		int sec = gc.get(Calendar.SECOND);		// 초
		int milsec = gc.get(Calendar.MILLISECOND);	// 밀리세컨
		
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch (week) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		
		System.out.print((ampm==0)?"오전 ":"오후 ");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minite,sec,milsec);
		System.out.printf("24시간 단위 : %d시 %d분 %d초 %d\n", hour24, minite, sec, milsec);
	}
}
