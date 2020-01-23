package com.tj.ex1_trycatch;

public class Ex03 {
	public static void main(String[] args) {
		int[] iArr = {0,1,2};
				
		for(int i=0; i<iArr.length;i++) {
			try {
				System.out.println("iArr["+i+"] = "+iArr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : "+e.getMessage());
//				e.printStackTrace();
			} finally {
				System.out.println("try절 실행후나 catch절 실행후에도 이부분은 꼭 실행한다.");
			}
			
		}
	}
}
