package com.tj.ex4_dataBufferRWStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile\\inTest.txt");		// 기본스트림 열기
			br = new BufferedReader(reader);					// 보조스트림 열기
			while(true) {
				String lineStr = br.readLine();
				if(lineStr==null) {				// 파일이 끝이냐
					break;
				}
				System.out.println(lineStr);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 접근 실패 "+e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 읽기 실패 "+e.getMessage());
		} finally {
			try {
				if(br!=null) 
					br.close();
				if(reader!=null) 
					reader.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
