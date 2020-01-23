package com.tj.ex2_dataIOStream;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;		// 기본 스트림변수
		DataOutputStream dos = null;		// 보조 스트림변수
		
		try {
			fos = new FileOutputStream("txtFile\\dataFile.dat");
			dos = new DataOutputStream(fos);	// 보조스트림은 기본스트림을 이용해서 연다.
			dos.writeUTF("홍길동");
			dos.writeInt(2);
			dos.writeDouble(99.6);
		} catch (FileNotFoundException e) {
			System.out.println("폴더를 찿지 못했습니다." + e.getMessage());
		} catch (IOException e) {
			System.out.println("쓰기 예외발생 " + e.getMessage());
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
