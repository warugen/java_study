package com.tj.studentmng;

import java.util.Scanner;

public class StudentMngMain {
	public static void main(String[] args) {
		Student[] students = {	new Student(201901, "홍길동", 20, "기계"),
								new Student(201902, "김길동", 21, "경영"),
								new Student(201903, "신길동", 22, "컴공"),
								new Student(201904, "마길동", 20, "토목"),
								new Student(201905, "박길동", 23, "물리")
							 };
		Scanner sc = new Scanner(System.in);
		int no;			// 검색할 학번
		int idx;		// 검색한 학번이 가르키는 인덱스
		int fn;			// 기능번호 1.학번수정, 2.이름수정, 3.나이수정, 4.전공수정
		String data;	// 바꿀 데이터가 입력될 변수
		
		// 전체 학생들 출력
		for(Student s : students) {
			System.out.println(s.infoString());
		}
		
		while (true) {
			System.out.print("바꿀 학생의 학번은(종료를 원하면 0)?");
			no = sc.nextInt();
			
			if (no == 0) break;
			
			for (idx = 0; idx< students.length;idx++) {
				if(students[idx].getNo() == no) {
					break;		//idx에 해당 배열번호 저장됨
				}
			}
			
			if(idx == students.length) {
				System.out.println("검색하는 학번 번호가 없습니다. 다시 입력해주세요");
				continue;
			}
			
			// 기능번호 받고
			System.out.println(students[idx].infoString());
			do {
				System.out.print("1.학번수정, 2.이름수정, 3.나이수정, 4.전공수정 : ");
				fn = sc.nextInt();
				if(fn > 4 || fn <1) {
					System.out.println("유효하지않은 기능번호 입니다. 다시 선택해주세요");
				} else {
					break;
				}
			} while (true);
			
//			System.out.print("1.학번수정, 2.이름수정, 3.나이수정, 4.전공수정 : ");
//			fn = sc.nextInt();
//			if(fn > 4 || fn <1) {
//				System.out.println("유효하지않은 기능번호 입니다.");
//				continue;
//			}
			
			// 바꿀 데이터 받고
			System.out.print("바꿀 데이터를 입력하세요 :");
			data = sc.next();	// String 입력(white space전까지의 String)
			// 수정전 데이터 출력 - 수정 - 수정후 데이터 출력
			System.out.println("수정전 : "+students[idx].infoString());
			students[idx].modify(fn, data);
			System.out.println("수정후 : "+students[idx].infoString());
			
		}
		
		System.out.println("프로그램을 종료합니다. 최종 데이터는 다음과 같습니다.");
		for(Student s : students) {
			System.out.println(s.infoString());
		}
	}
}
