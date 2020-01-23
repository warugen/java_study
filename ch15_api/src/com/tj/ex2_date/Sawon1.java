package com.tj.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon1 {
	public static final String COMPUER = "COMPUER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	
	private String no;
	private String name;
	private String part;	//COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES
	private Date inDate;
	
	// Sawon1 kim = new Sawon1("d102-01","홍길동","PLANNING");
	// Sawon1 yi = new Sawon1("d102-01","홍길동","PLANNING",1999,12,11);
	public Sawon1(String no, String name, String part) {
		this.no = no;
		this.name = name;
		this.part = part;
		this.inDate = new Date();
	}
	
	public Sawon1(String no, String name, String part, int year, int month, int day) {
		this.no = no;
		this.name = name;
		this.part = part;
		this.inDate = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	
	public String infoString() {
		// [사번]d102-02 [이름]홍길동 [부서]DESIGN [입사일]1990년12월11일
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년M월d일");
		return "[사번]"+no+"\t[이름]"+name+"\t[부서]"+part+"\t[입사일]"+sdf.format(inDate);
	}
	
}
