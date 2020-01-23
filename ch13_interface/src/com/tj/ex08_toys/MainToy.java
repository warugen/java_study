package com.tj.ex08_toys;

public class MainToy {
	public static void main(String[] args) {
//		PhooToy phoo1 = new PhooToy();
//		IMoveArmLeg phoo2 = new PhooToy();
		IToy phoo = new PhooToy();
		
//		MazingaToy mazinga1 = new MazingaToy();
//		IMoveArmLeg mazinga2 = new MazingaToy();
//		IMissile mazinga3 = new MazingaToy();
		IToy mazinga = new MazingaToy();
		
//		AirplaneToy airplane1 = new AirplaneToy();
//		ILight airplan2 = new AirplaneToy();
		IToy airplane = new AirplaneToy();
		
		IToy[] toys = {phoo, mazinga, airplane};
		
		for(IToy t : toys) {
			System.out.println(t.getClass().getName());
		}
	}
}
