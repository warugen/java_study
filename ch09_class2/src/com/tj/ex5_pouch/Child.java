package com.tj.ex5_pouch;

public class Child {
	static MomPouch momPouch = new MomPouch();
	private String name;
	public Child(String name) {		// main함수에서 child first = new child("첫째길동이");
		this.name = name;
	}
	
	public void takeMoney(int money) {
		if (momPouch.money>=money) {
			momPouch.money = momPouch.money - money;
			System.out.println(name +"가"+money+"원 받아가서 엄마지갑에 "+momPouch.money+"원 남음");
		} else {
			System.out.println(name + "가 돈 못받음 엄마지갑에 돈이 모자라서");
		}
	}
}
