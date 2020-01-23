package com.tj.ex1_string;

import java.util.Scanner;

public class Ex07_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-08"),
				new Friend("김길동", "010-8888-8888", "02-18"),
				new Friend("양길동", "010-777-9999", "08-02")
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고자하는 친구의 전화번호 뒷자리는? ");
		String src = sc.next();
		int idx;
		boolean fndOK = false;
		
		for(Friend f : friends) {
			String tel = f.getTel();
			String postTel = tel.substring(tel.lastIndexOf('-')+1);
			if(postTel.equals(src)) {
				System.out.println(f.infoString());
				fndOK = true;
			}
		}
		
		if (!fndOK) {
			System.out.println("전화번호를 찿지 못했습니다.");
		}
	}
}
