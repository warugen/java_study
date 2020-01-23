package com.tj.ex01_store;

public class MainStore {
	public static void main(String[] args) {
		
		Store1 st1 = new Store1();
		Store2 st2 = new Store2();
		Store3 st3 = new Store3();
		

		System.out.println(st1.getStr());
		st1.kimch();
		st1.budae();
		st1.bibim();
		st1.sundae();
		st1.gongibap();
		
		System.out.println(st2.getStr());
		st2.kimch();
		st2.budae();
		st2.bibim();
		st2.sundae();
		st2.gongibap();
		
		System.out.println(st3.getStr());
		st3.kimch();
		st3.budae();
		st3.bibim();
		st3.sundae();
		st3.gongibap();
		
		HeadStore[] stArr = { 	new Store1(),
								new Store2(),
								new Store3()
		};
		
		for(HeadStore s : stArr) {
			if(s instanceof Store1) {
				System.out.println(((Store1)s).getStr());				
			} else if (s instanceof Store2){
				System.out.println(((Store2)s).getStr());
			} else if (s instanceof Store3){
				System.out.println(((Store3)s).getStr());
			}
			
			s.kimch();
			s.budae();
			s.bibim();
			s.sundae();
			s.gongibap();
			System.out.println("=============================");
		}
	}
}
