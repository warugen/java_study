package com.tj.ex6_vote;

import java.util.Random;

public class VoteThread extends Thread {
	private int count;
	private Random random;
	private StringBuilder graph;
	private final static int TARGETCNT = 100;
	public VoteThread(String name) {
		super(name);
		count = 0;
		random = new Random();
		graph = new StringBuilder();
	}
	@Override
	public void run() {
		// count 개표율을 random.nextInt(10)만큼 더하기
		// count 만큼 별 만들기
		// 지역이름(쓰레드이름), count(개표율), graph(별)를 출력
		while (true) {
			count += random.nextInt(10);
			if(count >= 100) {
				count = TARGETCNT;
				graph.delete(0, graph.toString().length());	// 기존의 별 지우기
				for(int i =0; i< count; i++) {		// count만큼 별 만들기
					graph.append('★');
				}
				// 출력
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% 개표 "+graph);
				break;
			}
			graph.delete(0, graph.toString().length());	// 기존의 별 지우기
			for(int i =0; i< count; i++) {		// count만큼 별 만들기
				graph.append('★');
			}
			// 출력
			System.out.println(Thread.currentThread().getName()+"\t"+count+"% 개표 "+graph);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
