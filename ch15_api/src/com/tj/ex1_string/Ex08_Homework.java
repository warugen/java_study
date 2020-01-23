package com.tj.ex1_string;

import java.util.Scanner;

public class Ex08_Homework {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("전화번호를 입력하세요.(종료는x) : ");
			String tel = sc.next();
			
			if(tel.equalsIgnoreCase("x")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			// 전화번호 형식 체크
			// 전화번호 길이(10글자 이상 15글자이하) 체크, '-'가 하나도없는지, 하나만 있는지, 두개 이상인지 체크 
			if ( tel.length() < 11 || tel.length() > 14 || tel.indexOf('-') == tel.lastIndexOf('-') || dashCnt(tel) >=3) {
				System.out.println("전화번호 형식이 틀렸습니다. 다시 입력해 주세요.");
				continue;
			}
			
			// 입력한 전화번호
			System.out.println("입력한 전화번호\t : " + tel);
			
			// 짝수 인덱스 문자열
			System.out.print("짝수 인덱스 문자열 : ");
			for(int i=0;i<tel.length();i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			
			// 문자를 거꾸로
			System.out.print("문자를 거꾸로\t: ");
			for(int i=tel.length()-1; i>=0;i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			
			// 전화번호 앞자리
			System.out.println("전화번호 앞자리\t: "+ tel.substring(0, tel.indexOf('-')));
			
			// 전화번호 뒷자리
			System.out.println("전화번호 뒷자리\t: " + tel.substring(tel.lastIndexOf('-')+1));
		}
	}
	
	public static int dashCnt(String str) {
		int cnt = 0;
		for(int i =0; i < str.length(); i++) {
			if (str.charAt(i)=='-') {
				cnt++;
			}
		}
		return cnt;
	}
}
