package com.tj.ex1_string;

import java.util.Scanner;

public class Ex05_TelNum {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999","010-8888-8888","02-908-1211"};
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고자하는 회원의 전화번호 뒷자리는? ");
		String src = sc.next();
		int idx;
		
		for (idx=0; idx < tels.length; idx++) {
			// 전화번호 뒷자리 빼내기
			String tmp = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if ( tmp.equals(src)) {
				System.out.println(tels[idx]);
				break;
			}
		}
		
		if (idx == tels.length) {
			System.out.println("전화번호를 찿지 못했습니다.");
		}
		sc.close();
	}
}
