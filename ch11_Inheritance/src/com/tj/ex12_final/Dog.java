package com.tj.ex12_final;

public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("뛰면서 꼬리를 흔들어요. 현재 속도 : "+speed);
	}
}
