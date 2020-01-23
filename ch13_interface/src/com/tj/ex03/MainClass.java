package com.tj.ex03;

public class MainClass {
	public static void main(String[] args) {
		
		InterfaceClass ifc = new InterfaceClass();
		ifc.calculate();
		ifc.getStr();
		ifc.toString();
		
		InterfaceEx1 if1 = new InterfaceClass();
		if1.calculate();
//		if1.getStr();	if1이 InterfaceEx1형 변수라서 안된다 되려면 InterfaceClass로 강제형변환
		
		InterfaceEx2 if2 = new InterfaceClass();
//		if2.calculate();if2이 InterfaceEx2형 변수라서 안된다 되려면 InterfaceClass로 강제형변환
		if2.getStr();
		
		System.out.println("InterfaceEx1상수 : "+InterfaceEx1.CONSTANT_NUM);
		System.out.println("InterfaceClass상수 : "+InterfaceClass.CONSTANT_NUM);
		System.out.println("InterfaceEx2상수 : "+InterfaceEx2.CONSTANT_STRING);
		System.out.println("InterfaceClass상수 : "+InterfaceClass.CONSTANT_STRING);
	}
}
