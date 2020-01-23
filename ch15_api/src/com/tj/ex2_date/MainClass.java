package com.tj.ex2_date;

public class MainClass {
	public static void main(String[] args) {
		Sawon1[] sa = { new Sawon1("d102-02", "홍길동", Sawon1.COMPUER),
				new Sawon1("a201-01", "이태리", Sawon1.ACCOUNTING),
				new Sawon1("b100-19", "최민식", Sawon1.PLANNING, 2010, 3, 1),
				new Sawon1("c101-02", "강동원", Sawon1.HUMANRESOURCES),
				new Sawon1("d102-09", "황정민", Sawon1.COMPUER, 1999, 1, 1)
				};
		
		for(Sawon1 s: sa) {
			System.out.println(s.infoString());
		}
		System.out.println();
		Sawon2 s1 = new Sawon2("c-101-11","김길동", PartType.ACCOUNTING);
		System.out.println(s1.infoString());
	}
}
