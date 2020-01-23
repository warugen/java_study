package com.tj.ex2_date;

import java.util.Calendar;

import com.tj.ex1_string.Friend;

public class Ex06_exam {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "031-999-9999", "12-11"),
				new Friend("김길동", "02-888-8888", "12-10"),
				new Friend("박길동", "010-777-7777", "12-16")
		};
		Calendar today = Calendar.getInstance();
		int month = today.get(Calendar.MONTH)+1;		// 0~11월 +1
		int day = today.get(Calendar.DAY_OF_MONTH);		// 1~31

		String monthStr = (month<10)?"0"+month:""+month;
		String dayStr = (day<10)?"0"+day:""+day;
		String todayStr = monthStr + "-" + dayStr;
//		String todayStr = ((month<10)?"0"+month:month) + "-" + ((day<10)?"0"+day:day);
		System.out.println(todayStr);
		
		// 오늘 생일인 사람 찿기
		System.out.println("오늘은 " + todayStr);
		boolean fndOk = false;
		
		for(Friend f : friends) {
			if(f.getBirth().equals(todayStr)) {
				System.out.println(f.infoString());
				fndOk = true;
			}
		}
		if (!fndOk) {
			System.out.println("오늘 생일인 사람을 찿지 못했습니다.");
		}
		
		// 이번달 생일인 사람 찿기
		System.out.println("이번달은 " + monthStr);
		fndOk = false;
		for(Friend f : friends) {
			String tmp = f.getBirth().substring(0, 2);
			if(tmp.equals(monthStr)) {
				System.out.println(f.infoString());
				fndOk = true;
			}
		}
		
		if (!fndOk) {
			System.out.println("이번달 생일인 사람을 찿지 못했습니다.");
		}
	}
}
