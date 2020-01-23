package strategy2.modularization;

import strategy2.inter.*;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EnginMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.print("소나타 ");
		super.shape();
	}
}
