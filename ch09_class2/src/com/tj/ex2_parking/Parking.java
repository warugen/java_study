package com.tj.ex2_parking;

import com.tj.cons.PiClass;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private static final int HOURPERFEE = 2000;
	
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		
		System.out.println(no+"님 어서오세요.");
		System.out.println("입차시간 : "+inTime+"시");
	}
	
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * PiClass.HOURPERFEE;
		System.out.println(no+"님 안녕히 가세요.");
		System.out.println("입차시간 : "+inTime+"시");
		System.out.println("출차시간 : "+outTime+"시");
		System.out.println("주차요금 : " + fee +"원");
	}
}
