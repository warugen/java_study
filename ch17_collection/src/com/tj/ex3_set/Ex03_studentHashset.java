package com.tj.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex03_studentHashset {
	public static void main(String[] args) {
		HashSet<Student> hashset = new HashSet<Student>();
		Student hong1 = new Student("홍길동", 1);
		Student hong2 = new Student("홍길동", 1);
		
		System.out.println(hong1.equals(hong2));
		System.out.println(hong1.hashCode());
		System.out.println(hong2.hashCode());
		
		hashset.add(hong1);
		hashset.add(hong2);
		hashset.add(new Student("홍길동", 1));
		hashset.add(new Student("고길동", 1));
//		hashset.remove(hong2);
		
		System.out.println(hashset);
		
		Iterator<Student> iter = hashset.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			
		}
	}
}
