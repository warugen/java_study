package com.tj.ex7_homework;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTest {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Writer writer = null;
		String str;
		String name;
		String phone;
		String birth;
		String address;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);

		try {
			writer = new FileWriter(".\\src\\com\\tj\\ex7_homework\\customer.txt");
			do {
				System.out.print("회원가입을 하시겠습니까?(종료는N(n), 입력하려면 아무키나 입력 :");
				str = keyboard.readLine();
				if(str.equalsIgnoreCase("n")) {
					System.out.println("입력을 종료합니다.");
					// 종료할때 파일저장, 콘솔창에 출력
					for(Customer c: customers) {
						writer.write(c.toString());
						System.out.println(c);
					}
					writer.write("\t\t\t이하 "+customers.size()+"명 가입\r\n");
					System.out.println("\t\t\t이하 "+customers.size()+"명 가입");
					break;
				}
				System.out.print("이름을 입력하세요 : ");
				name = keyboard.readLine();
				System.out.print("전화번호를 입력하세요 : ");
				phone = keyboard.readLine();
				System.out.print("생일을 입력하세요 : ");
				birth = keyboard.readLine();
				
				sdf.parse(birth);
				System.out.print("주소를 입력하세요 : ");
				address = keyboard.readLine();
				
				// 오늘 생일이니 체크
				if(birth.equals(todayStr)) {
					System.out.println(name+"님 생일이시군요. 생일축하드립니다.");
				}
				// arraylist에 저장
				customers.add(new Customer(name, phone, birth, address));

			} while(true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(writer!=null)writer.close();
				if(keyboard!=null)keyboard.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
