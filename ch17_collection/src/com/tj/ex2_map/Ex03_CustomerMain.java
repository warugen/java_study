package com.tj.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.tj.ex1_list.Customer;

public class Ex03_CustomerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		
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
				customers.put(phone, new Customer(name, phone, addr));
			}
		} while (true);
		
		Iterator<String> iter = customers.keySet().iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(customers.get(key));
		}
		
		sc.close();
	}
}
