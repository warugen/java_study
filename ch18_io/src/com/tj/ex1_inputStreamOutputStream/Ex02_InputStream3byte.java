package com.tj.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_InputStream3byte {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("D:\\mega_IT\\inTest.txt");
			byte[] bs = new byte[10];
			while (true) {
				int nREADByte = is.read(bs);	// 10바이트씩 읽기
				
				if (nREADByte == -1) {
					break;
				}
				for(int i=0; i < nREADByte; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찿지 못했습니다." + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 읽지 못했습니다." + e.getMessage());
		} finally {
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println("파일을 닫지 못했습니다." + e.getMessage());
			}
			
		}
	}
}
