package strategy2.modularization;

import strategy2.inter.*;

public class Car {
	private IEngine engine;
	private IFuel fuel;
	private IKm km;
	
	public void drive() {
		System.out.println("드라이브 할 수 있다.");
	}
	public void shape() {
		System.out.println("차 모양은 door, sheet, handle로 이루어져 있습니다.");
	}
	
	public void isEngine() {
		engine.engine();
	}
	
	public void isKmPerLitter() {
		km.kmPerLitter();
	}
	
	public void isFuel() {
		fuel.fuel();
	}

	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}

	public void setKm(IKm km) {
		this.km = km;
	}
	
	
}
