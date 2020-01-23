package strategy2.modularization;

import strategy2.inter.*;

public class Genesis extends Car{
	
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.print("제네시스 ");
		super.shape();
	}
}
