package com.tj.car;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("빨강");
		System.out.println(myPorsche.getColor());

		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("그레이색이야");
		System.out.println(yourPorsche.getColor());
		Car hisPorsche = yourPorsche;
		System.out.println(hisPorsche.getColor());

	}
}
