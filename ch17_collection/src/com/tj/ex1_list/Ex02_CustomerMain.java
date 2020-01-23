package com.tj.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02_CustomerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String answer, name, phone, addr;
		
		do {
			System.out.print("회원등록 하시겠습니까?(거부는 N(n)) :");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("종료합니다. 회원리스트출력");
				break;
			} else if (answer.equalsIgnoreCase("y")){
				System.out.print("가입할 회원의 이름은? : ");
				name = sc.next();
				System.out.print("가입할 회원의 전화번호는? : ");
				phone = sc.next();
				System.out.print("가입할 회원의 주소는? : ");
				sc.nextLine();	// 스캐너 버퍼 비우기
				addr = sc.nextLine();
				customers.add(new Customer(name, phone, addr));
			}
		} while (true);
		
		System.out.println(customers);
		for(Customer c: customers) {
			System.out.println(c);
		}
		for(int i=0; i<customers.size();i++ ) {
			System.out.println(customers.get(i));
		}
		
		sc.close();
	}
}
