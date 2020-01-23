package strategy2.modularization;

import strategy2.inter.*;

public class MainClass {
	public static void main(String[] args) {
	
		Car[] cars = { new Genesis(), new Sonata(), new Accent()};
		cars[1].setFuel(new FuelHybrid());
		for (Car c : cars) {
			System.out.println("====================================");
			c.shape();
			c.drive();
			c.isEngine();
			c.isKmPerLitter();
			c.isFuel();
		}
	}
}
