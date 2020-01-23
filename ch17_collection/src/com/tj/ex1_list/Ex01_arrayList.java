package com.tj.ex1_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		// String 배열
		String[] array =new String[5];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		array[3] = "str3";
		array[4] = "str4";
		array[1] = "str1111";
		
//		for(String s: array) {
//			System.out.println(s);
//		}
		
		for(int idx=0; idx<array.length; idx++) {
			System.out.println(idx + "번째 "+array[idx]);
		}
		
		// String ArraryList
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("str0");	// 0번 인덱스
		arraylist.add("str1");	// 1번 인덱스
		arraylist.add("str2");	// 2번 인덱스
		arraylist.add("str3");	// 3번 인덱스
		arraylist.add("str4");	// 4번 인덱스
		arraylist.add(1, "str111");		//0번과 1번사이에 들어가서 1번이되고 기존1번은 2번인덱스가된다.
		arraylist.set(2, "str12121212");	//기존1번 인덱스 값을 수정
				
		for(int idx=0; idx<arraylist.size(); idx++ ) {
			System.out.println(idx+"번째 "+arraylist.get(idx));
		}
		
		arraylist.remove(3);	// 3번 인덱스 삭제
		
		System.out.println(arraylist);
		arraylist.clear();	// arrayList의 모든 데이터를 지움(size()가 0으로나옴)
		if (arraylist.isEmpty()) {
			System.out.println("arraylist.clear()됨");
		}
		
		arraylist = null;
			
	}
}
