package com.tj.ex1_string;

public class Ex01_String {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		if (str1 == str2) {
			System.out.println("str1과 str2는 같은 주소다.");
		} else {
			System.out.println("str1과 str2는 다른 주소다.");
		}
		
		if (str3 == str4) {
			System.out.println("str3과 str4는 같은 주소다.");
		} else {
			System.out.println("str3과 str4는 다른 주소다.");
		}
		
		System.out.println("str1과 str2가 같은 스트링이냐?"+(str1.equals(str2)));
		System.out.println("str1과 str3이 같은 스르링이냐?"+(str1.equals(str3)));
		System.out.println("str1의 hashcode : "+str1.hashCode());
		System.out.println("str2의 hashcode : "+str2.hashCode());
		System.out.println("str3의 hashcode : "+str3.hashCode());
		System.out.println("str4의 hashcode : "+str4.hashCode());
	}
}
