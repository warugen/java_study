package com.tj.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile\\outTest.txt",true);
			String str = "안녕하세요\r\n반갑습니다.";
			byte[] bs = str.getBytes();
//			for(int i=0; i<bs.length;i++) {
//				os.write(bs[i]);
//				System.out.print((char)bs[i]);
//			}
			os.write(bs);
		} catch (FileNotFoundException e) {
			System.out.println("파일경로를 찿지못했습니다."+e.getMessage());
		} catch (IOException e) {
			System.out.println("파일쓰기 오류"+e.getMessage());
		} finally {
			try {
				if(os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
