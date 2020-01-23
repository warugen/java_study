package com.tj.ex6_wrapper;
// java 클래스명 100 20 10....명령파라미터로 들어온 문자열을 숫자로 바꿔서 합을 구하기
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("들어온 값 갯수 : "+args.length);
		int total = 0;
		for(String s : args) {
			System.out.println(s);
			total += Integer.parseInt(s);
		}
		System.out.println("전체 합은 "+total);
	}
}
