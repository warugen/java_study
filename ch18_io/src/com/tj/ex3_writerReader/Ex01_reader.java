package com.tj.ex3_writerReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile\\inTest.txt");
			while(true) {
				int i = reader.read();
				if ( i == -1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 접근 실패 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 읽기 실패 " + e.getMessage());
		} finally {
			try {
				if(reader != null)reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
