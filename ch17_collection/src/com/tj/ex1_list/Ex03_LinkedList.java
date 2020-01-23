package com.tj.ex1_list;

import java.util.LinkedList;

public class Ex03_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("str0");
		linkedlist.add("str1");
		linkedlist.add("str2");
		linkedlist.add("str3");
		linkedlist.add(0, "str00000");
		linkedlist.set(0, "000str");
		
		linkedlist.remove(1);
		
		for(int i=0; i< linkedlist.size(); i++) {
			System.out.println(linkedlist.get(i));
		}
		
		System.out.println(linkedlist);
		
		linkedlist.clear();
		System.out.println(linkedlist.isEmpty()?"비워졌다.":"남아있다");
	}
}
