package com.tj.ex05_actor;

public class MainClass {
	public static void main(String[] args) {
		Actor ac = new Actor("박보검");
		
		ac.outFire();
		ac.saveMan();
		ac.makePizza();
		ac.makeSpaghetti();
		ac.canCatchCriminal();
		ac.canSearch();
		
		FireMan firePark = ac;
		firePark.outFire();
		firePark.saveMan();
//		firePark.makePizza();
//		firePark.makeSpaghetti();
//		firePark.canCatchCriminal();
//		firePark.canSearch();
		
		Chef chefPark = ac;
		chefPark.makePizza();
		chefPark.makeSpaghetti();
//		chefPark.outFire();
//		chefPark.saveMan();
//		chefPark.canCatchCriminal();
//		chefPark.canSearch();
		
		PoliceMan policePark = ac;
//		policePark.outFire();
//		policePark.saveMan();
//		policePark.makePizza();
//		policePark.makeSpaghetti();
		policePark.canCatchCriminal();
		policePark.canSearch();
		
	}
}
