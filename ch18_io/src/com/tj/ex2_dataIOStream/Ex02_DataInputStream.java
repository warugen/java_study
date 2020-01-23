package com.tj.ex2_dataIOStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("txtFile\\dataFile.dat");
			dis = new DataInputStream(fis);
			String name = dis.readUTF(); // 파일에 쓴 순서대로 읽는다. String -> int -> double순서
			int num = dis.readInt();
			double dnum = dis.readDouble();
			System.out.println("파일로 부터 입력받은 값은 : " + name + "\t" + num + "\t" + dnum);
		} catch (FileNotFoundException e) {
			System.out.println("파일 열기 예외 " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
