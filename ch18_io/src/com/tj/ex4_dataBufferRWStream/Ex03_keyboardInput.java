package com.tj.ex4_dataBufferRWStream;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class Ex03_keyboardInput {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Writer writer = null;
		try {
			System.out.print("작성할 파일 이름을 입력하세요 : ");
			String filename = keyboard.readLine();
			writer = new FileWriter(filename);		// 입력받은 파일이름으로 스트림열기
			while(true) {
				System.out.print("입력할 내용은?(입력종료시 x입력 : ");
				String content = keyboard.readLine();
				if(content.equalsIgnoreCase("x")) {
					System.out.println("입력을 종료합니다.");
					break;
				}
				writer.write(content+"\r\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null)writer.close();
				if(keyboard!=null)keyboard.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
