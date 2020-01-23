package com.tj.ex2_dataIOStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductArrayList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream fis = null;
		DataInputStream dis = null;
		
		String name;
		int price, ps;
		
		try {
			fis = new FileInputStream("txtFile\\product.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				name = dis.readUTF();
				price = dis.readInt();
				ps = dis.readInt();
				// arraylist에 담기
				products.add(new Product(name, price, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 열기 실패" + e.getMessage());
		} catch (IOException e) {
			System.out.println("product.dat 파일 내용을 arraylist에 전부 담음");
		} finally {
			try {
				if(dis!=null)dis.close();
				if(fis!=null)fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("이상 "+products.size()+"개 재고 입력됨");
	}
}
