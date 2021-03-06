package com.tj.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 입력스트림 연다, 출력스트림 연다 -> 데이터 읽고 읽은데이터 쓴다 -> 입력,출력스트림 닫기
public class FileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("txtFile\\sana.jpg");
			os = new FileOutputStream("txtFile\\samiho.jpg");
			int cnt = 0;
			while(true) {
				cnt++;
				int i = is.read();	// 읽고
				if(i == -1) {
					break;
				}
				os.write(i);		// 쓰고
			}
			System.out.println("파일 카피 끝. while문 몇번 돌았는지 : " +cnt);
		} catch (FileNotFoundException e) {
			System.out.println("파일 열기 실패 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 읽기 실패 "+e.getMessage());
		}finally {
			if(os!=null)
				try {
						os.close();
						if(is!=null)is.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
