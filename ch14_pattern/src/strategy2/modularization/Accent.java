package strategy2.modularization;

import strategy2.inter.*;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	
	@Override
	public void shape() {
		System.out.print("엑센트 ");
		super.shape();
	}
}
