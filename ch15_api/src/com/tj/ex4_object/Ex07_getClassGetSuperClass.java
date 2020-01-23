package com.tj.ex4_object;

public class Ex07_getClassGetSuperClass {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10, 5, "검정색");
		Class cls = obj.getClass();
		System.out.println(cls.getName());
		
		System.out.println(cls.getName().substring(cls.getName().lastIndexOf('.')+1));
		
		Class superCls = cls.getSuperclass();
//		Class superCls = obj.getClass().getSuperclass();
		
		System.out.println(superCls);
		
	}
}
