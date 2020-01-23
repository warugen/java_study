package com.tj.ex3_writerReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile\\outTest.txt",true);
			String str = "안녕하세요 펭수입니다.\r\n";
			writer.write(str);
		} catch (IOException e) {
			System.out.println("파일 접근 실패" + e.getMessage());
		} finally {
			try {
				if(writer!=null)writer.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
