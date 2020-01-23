package com.tj.ex04_lunch;

public class Child1 extends LunchMenu {

	public Child1(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		super(rice, bulgogi, soup, milk, banana, almond);
		setStr("Child1형 식대 : ");
	}

	@Override
	public int calculate() {
		// 밥값, 불고기값, 국값, 바나나값 ,아몬드값
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
