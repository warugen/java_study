package com.tj.ex05_car;

import com.tj.cons.CarSpecs;

public class CarMain {
	public static void main(String[] args) {
		Car lowCar = new LowGradeCar(CarSpecs.COLOR_BLACK, CarSpecs.TIRE_NORMAL, 
				CarSpecs.DISPLACEMENT_1500, CarSpecs.HANDLE_POWER);
		Car highCar = new HighGradeCar(CarSpecs.COLOR_RED, CarSpecs.TIRE_WIDE, 
				CarSpecs.DISPLACEMENT_2000, CarSpecs.HANDLE_POWER);
		
		lowCar.getSpec();
		System.out.println("=======================");
		highCar.getSpec();
	}
}
