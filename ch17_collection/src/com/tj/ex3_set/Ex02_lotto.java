package com.tj.ex3_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
//		HashSet<Integer> lotto = new HashSet<Integer>();	// 입력된 순서되로 저장
		TreeSet<Integer> lotto = new TreeSet<Integer>();	// 입력된 값을 정렬하면서 저장
		Random random = new Random();
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
	}
}
