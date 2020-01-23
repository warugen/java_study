package com.tj.ex;
// 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄때 몇개씩 주어야 하나?
public class Ex11 {
	public static void main(String[] args) {
		int[] coinUnit = {500,100,50,10};
		
		int money = 2680;
		
		// 일반 for
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i]+"원 짜리는" + money/coinUnit[i] + "개 , ");
			money = money % coinUnit[i];
		}
		
		//확장 for
		for(int coin : coinUnit) {
			System.out.println(coin+"원 짜리는" + money/coin + "개 , ");
			money = money % coin;
		}
	}
}
