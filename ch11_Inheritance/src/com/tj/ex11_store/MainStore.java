package com.tj.ex11_store;

public class MainStore {
	public static void main(String[] args) {
		HeadStore st = new HeadStore();
		Store1 st1 = new Store1();
		Store2 st2 = new Store2();
		Store3 st3 = new Store3();
		
		System.out.println(st.getStr());
		st.kimch();
		st.budae();
		st.bibim();
		st.sundae();
		st.gongibap();
		
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
		
		HeadStore[] stArr = { new HeadStore(),
								new Store1(),
								new Store2(),
								new Store3()
		};
		
		for(HeadStore s : stArr) {
			System.out.println(s.getStr());
			s.kimch();
			s.budae();
			s.bibim();
			s.sundae();
			s.gongibap();
			System.out.println("=============================");
		}
	}
}
