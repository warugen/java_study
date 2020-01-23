package com.tj.ex2_date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_date {
	public static void main(String[] args) {
		// 현재
		Calendar calnow = Calendar.getInstance();
		GregorianCalendar gcnow = new GregorianCalendar();
		Date datenow = new Date();
		System.out.printf("cal = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",calnow);
		System.out.printf("gc = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",gcnow);
		System.out.printf("date = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",datenow);
		
		// 특정시점 (1990.12.11)
		GregorianCalendar gcThat = new GregorianCalendar(1990,11,11);
		Date dateThat1 = new Date(90, 11, 11);
		Date dateThat2 = new Date(gcThat.getTimeInMillis());
		Date dateThat3 = new Date(new GregorianCalendar(1990, 11, 11).getTimeInMillis());
		
		System.out.printf("gc = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",gcThat);
		System.out.printf("date1 = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",dateThat1);
		System.out.printf("date2 = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",dateThat2);
		System.out.printf("date3 = %1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",dateThat3);
	}
}
