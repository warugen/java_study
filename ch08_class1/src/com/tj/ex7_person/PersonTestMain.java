package com.tj.ex7_person;

public class PersonTestMain {
	public static void main(String[] args) {
		PersonInfo hong = new PersonInfo();
		PersonInfo hong2 = new PersonInfo("È«±æ¼ø", 19, 'f');
		
		hong.setName("È«±æµ¿");
		hong.setAge(20);
		hong.setGender('m');
		
		
		PersonInfo[] hongs = new PersonInfo[2];
		
		
		hongs[0] = new PersonInfo();
		
		hongs[0].setName("È«±æ¼ø");
		hongs[0].setAge(19);
		hongs[0].setGender('f');
		
		
		hongs[1] = new PersonInfo("È«±æµ¿", 20, 'm');
		
		for(PersonInfo p : hongs) {
			p.print();
		}
		
//				
//		hong.print();
//		hong2.print();
//		
		
	}
}
