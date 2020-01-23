package com.tj.ex4_object;

public class MainClass {
	public static void main(String[] args) {
		Goods[] goods = {new Goods("a01", "새우깡", 1500, 500),
				new Goods("a02", "양파링", 1300, 10)
		};
		
		Customer[] customers = { new Customer("010-9999-9999", "홍길동", "12-11"),
				new Customer("010-8888-8888", "김삼순", "12-10")
		};
		
		for(Goods g : goods) {
			System.out.println(g.toString());
		}
		
		for(Customer c : customers) {
			System.out.println(c.toString());
		}
	}
}
