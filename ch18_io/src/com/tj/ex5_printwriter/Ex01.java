package com.tj.ex5_printwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		// 1byte 기본스트림
		OutputStream os = null;
		// 2byte 기본스트림
		Writer writer = null;
		// 보조 스트림
		PrintWriter pw = null;		
		try {
			writer = new FileWriter("txtFile\\outTest.txt",true);
			os = new FileOutputStream("txtFile\\outTest.txt", true);
//			pw = new PrintWriter(os);
//			pw = new PrintWriter(writer);
			pw = new PrintWriter("txtFile\\outTest.txt");	// 파일에 이어쓰기 불가
			System.out.println("안녕하세요\n반갑습니다.");
			pw.println("안녕하세요\r\n방가방가");
			pw.printf("%5s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			pw.printf("%5s %3d %3d %5.1f\n", "고길동", 80, 100, 90.0);
			pw.printf("%5s %3d %3d %5.1f\n", "마길동", 100, 70, 80.0);
			System.out.printf("%1$ty년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초" , new Date());
			pw.printf("%1$ty년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초" , new Date());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pw.close();
//				if(writer!=null)writer.close();
//				if(os!=null)os.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
