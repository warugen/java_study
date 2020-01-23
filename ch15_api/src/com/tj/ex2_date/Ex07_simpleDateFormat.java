package com.tj.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex07_simpleDateFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// yyyy 2019 yy 19 / M 9 MM 09 / d 9 dd 09 / D 올해의 몇번째 날인지(1~365)
		// E 요일 / 
		// a 오전/오후
		// H 24시간 HH 두자리
		// h 12시간 hh 두자리
		// m mm
		// s 초
		// S밀리세컨
		// W 이번 월의 몇번째 주인지
		// w 이번 년도의 몇번째 주인지
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		String todayStr = sdf.format(cal.getTime());
		System.out.println(todayStr);
	}
}
