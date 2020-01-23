package com.tj.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "   java   ";
		System.out.println("1."+str1.concat(str2));
		System.out.println("2."+str1.substring(3));
		System.out.println("3."+str1.substring(3,5));	// 3번인덱스부터 5번 앞까지
		System.out.println("4."+str1.length());
		System.out.println("5."+str1.toUpperCase());	// 대문자로 출력
		System.out.println("6."+str1.toLowerCase());	// 소문자로 출력
		System.out.println("7."+str1.charAt(3));		// 3번 인덱스의 문자를 가져옴
		System.out.println("8."+str1.indexOf('b'));		// 첫번째 b가 나오는 인덱스
		System.out.println("9."+str1.lastIndexOf('b'));	// 마지막 b가 나오는 인덱스
		
		String str4 = "abcXabcXabcXabc";
		System.out.println("10."+str4.indexOf('b', 6));	// 6번 인덱스부터 b를 찿는다.
		System.out.println("11."+ str4.indexOf("Xa"));	// 첫번째 Xa가 나오는 인덱스
		System.out.println("12."+str4.indexOf('z'));	// 첫번째 z가 나오는 인덱스 못찿으면 -1리턴
		System.out.println("13."+str1.equals(str2));	// str1과 str2가 같은 문자인지
		System.out.println("14."+str1.equalsIgnoreCase(str2));// 대소문자 구별없이 같은 문자인지
		System.out.println("15."+str3+str3.trim());	// 앞뒤 공백 제외 문자열 사이의 공백은 제거 못함
		System.out.println("16."+str4.replace('a', '9'));	// 'a'를 '9'로 변경
		System.out.println("17."+str4.replace("abcX", "바꿔"));
		System.out.println("str1 : "+str1+"\tstr2 : "+str2+"\tstr3 : "+str3+"\tstr4 : "+str4);
	}
}
