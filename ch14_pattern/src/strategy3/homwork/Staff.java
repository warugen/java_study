package strategy3.homwork;

import strategy3.homwork.inter.GetSalary;
import strategy3.homwork.inter.JobMng;

public class Staff extends Person {
	private String part;
//	public Staff() {
//		setJob(new JobMng());
//	}
	public Staff(String id, String name, String part) {
		super(name, id);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t 부서 : "+part);
	}

}
