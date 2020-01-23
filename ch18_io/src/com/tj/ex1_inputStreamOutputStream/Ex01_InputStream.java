package com.tj.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 파일입력(inTest.txt)-> 1.스트림을 연다 2.읽는다 3.파일닫기
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("D:\\mega_IT\\inTest.txt");
			while (true) {
				int i = is.read();	// 2.(1byte)읽는다.
				if(i==-1) {
					break;	// -1이면 파일의 끝
				}
				System.out.println((char)i+"의 아스키코드값: "+i);
				
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
