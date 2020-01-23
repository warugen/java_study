package com.tj.ex1_string;

public class Ex10_StringBuilder {
	public static void main(String[] args) {
		String str = "java";
		StringBuilder sbd = new StringBuilder("abc");
		StringBuffer sbff = new StringBuffer("xyz");
		sbd.append("def");
		System.out.println(sbd);		// sbd내용이 변한다 String객체는 안변함
		sbd.insert(3, "AAA");
		System.out.println(sbd);
		sbd.delete(3, 5);
		System.out.println(sbd);
		sbd.deleteCharAt(3);
		System.out.println(sbd);
		int capaSize = sbd.capacity();
		System.out.println(capaSize);
		sbd.append("가나다라마바사아자차카타파하갸거겨고교구규그기");
		System.out.println(sbd);
		capaSize = sbd.capacity();
		System.out.println(capaSize);
	}
}
