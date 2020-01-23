package com.tj.ex4_accestest2;

import com.tj.ex3_accestest1.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();

//		System.out.println(obj.privateMemeber);
//		obj.privateMethod();

//		System.out.println(obj.defaultMember);
//		obj.defaultMethod();
//
//		System.out.println(obj.protectedMember);
//		obj.protectedMethod();

		System.out.println(obj.publicMember);
		obj.publicMethod();
	}
}
