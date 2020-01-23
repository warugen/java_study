package com.tj.ex4_dataBufferRWStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Ex02_keyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Reader reader = null;
		BufferedReader br = null;
		
		try {
			System.out.print("읽어올 파일 이름은? : ");
			String filename = keyboard.readLine();	// 파일 이름 입력
			File file = new File(filename);			// 파일이름으로 파일객체 생성
			if(file.exists()) {		// 존재하는 파일
				reader = new FileReader(file);		// 기본 스트림 열기
				br = new BufferedReader(reader);	// 보조 스트림 열기
				
//				while((str = br.readLine())!=null) {
				while(true) {
					String str = br.readLine();
					if(str==null)break;
					System.out.println(str);
				}
			} else {
				System.out.println("입력하신 파일은 존재하지 않습니다.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null)br.close();
				if(reader!=null)reader.close();
				if(keyboard!=null)keyboard.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
