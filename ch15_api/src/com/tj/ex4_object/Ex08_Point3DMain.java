package com.tj.ex4_object;

public class Ex08_Point3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D(1.1, 2.4, 3.0);
		Point3D p3 = p2;
		Point3D p4 = (Point3D)p2.clone();
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p2.equals(p3));
		
		if(p4 == p2) {
			System.out.println("같은 객체");
		} else {
			System.out.println("복사한 객체");
		}
	}
}
