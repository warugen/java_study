package com.tj.ex2_dataIOStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_productMain {
	public static void main(String[] args) {
		// x를 입력할때까지 재고 입력(물건명, 가격, 재고수량)받아 파일에 저장
		Scanner sc = new Scanner(System.in);
		String answer;
		InputStream fis = null;
		DataInputStream dis = null;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile\\product.dat",true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("재고가 더 있나요?(중단을 원하면 x, 계속입력은 아무키입력) : ");
				answer = sc.next();
				if(answer.equalsIgnoreCase("x")) {
					System.out.println("입력을 종료합니다.");
					break;
				}
				
				System.out.print("물건명은 ? :");
				dos.writeUTF(sc.next());
				System.out.print("물건가격은 ? :");
				dos.writeInt(sc.nextInt());
				System.out.print("물건재고수량은 ? :");
				dos.writeInt(sc.nextInt());
				
			} while (true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
